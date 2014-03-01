/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import static name.dougmcneil.plsql.Loggers.DRIVER_LOG;
import static name.dougmcneil.plsql.Loggers.INIT_LOG;
import static name.dougmcneil.plsql.Loggers.EVENT_LOG;
import static name.dougmcneil.plsql.Loggers.EVENT_MSG;
import org.netbeans.api.db.explorer.ConnectionListener;
import org.netbeans.api.db.explorer.ConnectionManager;
import org.netbeans.api.db.explorer.DatabaseConnection;
import org.netbeans.api.db.explorer.DatabaseException;
import org.netbeans.api.db.explorer.JDBCDriver;
import org.netbeans.api.db.explorer.JDBCDriverManager;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 * Controls Driver initialization sequence.
 * If Oracle thin driver is registered and has an URL an attempt to register is made.
 * 
 * @author doug
 */
public final class PLSQLDriver implements ConnectionListener, PropertyChangeListener {
    
    public static final String DRIVER_CLASS = "name.dougmcneil.plsql.sql.Driver";
    public static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.OracleDriver";
    public static final String ORACLE_DRIVER_JAR_PROP = "name.dougmcneil.plsql.oracle-jar";
    
    public static enum CommProperties {
        /** the PropertyChangeSupport object */
        DRIVER_CHANGER,
        /** Parent Logger object */
        DRIVER_LOGGER,
        /** Event logger object */
        EVENT_LOGGER,
        /** Init logger object */
        INIT_LOGGER,
        /** new connection */
        NEW_CONNECTION,
        /** new statement */
        NEW_STATEMENT,
        /** line of DBMS_OUTPUT */
        DBMS_OUTPUT_LINE,
        /** Disconnected connection */
        DISCONNECTED,
        /** String error message from DBMS_OUTPUT */
        ERROR_DBMS_OUTPUT;
    }
    
    public static enum Status { 
        NOT_REGISTERED, REGISTERED, NO_DRIVER_OR_NO_JAR, NO_PLSQL_JAR, CANNOT_CREATE_DRIVER;
    }

    public static Status _status = Status.NOT_REGISTERED;
    
    private static final PLSQLDriver INSTANCE = new PLSQLDriver();
    
    private DriverChange _changer = new DriverChange();
    
    private InputOutput _io;
    
    @SuppressWarnings("LeakingThisInConstructor")
    private PLSQLDriver() {
        // start listening to Driver/Connections 
        // @todo might refine to specify what properties to listen to
        _changer.addPropertyChangeListener(CommProperties.NEW_CONNECTION.name(), this);
        _changer.addPropertyChangeListener(CommProperties.NEW_STATEMENT.name(), this);
        _changer.addPropertyChangeListener(CommProperties.DISCONNECTED.name(), this);
        _changer.addPropertyChangeListener(CommProperties.DBMS_OUTPUT_LINE.name(), this);
        _changer.addPropertyChangeListener(CommProperties.ERROR_DBMS_OUTPUT.name(), this);
        init();
        //ConnectionManager.getDefault().addConnectionListener(this);
    }
    
    public static PLSQLDriver getInstance() {
        return INSTANCE;
    }
    
    /** Status indicating error or null */
    public Status getStatus() {
        return _status;
    }
    
    /**
     * Initialize driver (register) not on awt thread
     */
    public void init() {
        if (_status == Status.REGISTERED) {
            return;
        }
        try {
            FileUtil.runAtomicAction(new FileSystem.AtomicAction() {

                public void run() {
                    JDBCDriver driver = registerDriver();
                    if (driver != null) {
                        initDriver(driver);
                    }
                    
                }
            });
        } catch (IOException e) {
            Exceptions.printStackTrace(e);
        }
    }
    
    private static JDBCDriver registerDriver() {
        // need oracle thin driver with OJDBC jar defined
        JDBCDriver[] drivers = JDBCDriverManager.getDefault().getDrivers(ORACLE_DRIVER_CLASS);
        URL url = null;
        for (JDBCDriver driver: drivers) {
            URL[] urls = driver.getURLs();
            if (urls.length > 0) {
                url = urls[0];
            }
        }
        if (url == null) {
            _status = Status.NO_DRIVER_OR_NO_JAR;
            INIT_LOG.log(Level.SEVERE, "No Oracle driver or no jar specified.");
            return null;
        }
        System.setProperty(ORACLE_DRIVER_JAR_PROP, url.toExternalForm());
        
        // check on existing drivers
        drivers = JDBCDriverManager.getDefault().getDrivers(DRIVER_CLASS);
        if (drivers.length > 0) {
            _status = Status.REGISTERED;
            INIT_LOG.log(Level.INFO, "Existing registration");
            return drivers[0];
        }
        
        // add driver - @todo InstalledFileLocator/Places
        File file = new File(new File(System.getProperty("netbeans.user"),"modules"),
                "name-dougmcneil-plsql.jar");
        // jar must exist
        if (!file.exists()) {
            _status = Status.NO_PLSQL_JAR;
            INIT_LOG.log(Level.SEVERE, "No name-dougmcneil-plsql.jar in netbeans.user module directory");
            return null;
        }
        
        try {
            JDBCDriver newDriver = null;
            try {
                newDriver = JDBCDriver.create("plsql_wrapper", "PLSQL Wrapping Driver", DRIVER_CLASS,
                        new URL[]{file.toURI().toURL()});
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
                return null;
            }
            JDBCDriverManager.getDefault().addDriver(newDriver);
            _status = Status.REGISTERED;
            INIT_LOG.log(Level.INFO, "Registration complete");
            return newDriver;
         } catch (DatabaseException e) {
             _status = Status.CANNOT_CREATE_DRIVER;
            INIT_LOG.log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    @Override
    public void connectionsChanged() {
        EVENT_LOG.log(Level.FINE, "Connections changed...");
        DatabaseConnection[] connections = ConnectionManager.getDefault().getConnections();
        for (DatabaseConnection connection: connections) {
            if (DRIVER_CLASS.equals(connection.getJDBCDriver().getClassName())) {
            }
        }
    }

    // All "communication" between Driver/Connection and PLSQLDRiver flows through here
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (CommProperties.valueOf(evt.getPropertyName())) {
            case DBMS_OUTPUT_LINE:
                String[] output = (String []) evt.getNewValue();
                _io.getOut().println(String.format("%s : MSG: %s", output[0], output[1]));
                break;
            case NEW_CONNECTION:
            case NEW_STATEMENT:
            case DISCONNECTED:
                _io = IOProvider.getDefault().getIO("PL/SQL", false);
                _io.getOut().println();
            case ERROR_DBMS_OUTPUT:
                EVENT_LOG.log(Level.INFO, String.format(EVENT_MSG, evt.getPropertyName(),
                        evt.getNewValue()));
                break;
            default:
                EVENT_LOG.log(Level.WARNING, String.format("Unknown property change: %s", 
                        evt.getPropertyName()));
                break;
        }
    }
    
    // When plsql driver is first created (or found on startup) it must be integrated with NetBeans
    private void initDriver(JDBCDriver driver) {
        try {
            Properties props = new Properties();
            props.put(CommProperties.DRIVER_CHANGER.name(), _changer);
            props.put(CommProperties.DRIVER_LOGGER.name(), DRIVER_LOG);
            props.put(CommProperties.EVENT_LOGGER.name(), EVENT_LOG);
            props.put(CommProperties.INIT_LOGGER, INIT_LOG);
            driver.getDriver().connect(name.dougmcneil.plsql.sql.Driver.INIT_URL, props);
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (DatabaseException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private class DriverChange extends PropertyChangeSupport {
        private DriverChange() {
            super(PLSQLDriver.this);
            
        }
    }
}
