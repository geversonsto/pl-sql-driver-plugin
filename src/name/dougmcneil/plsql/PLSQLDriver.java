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
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import static name.dougmcneil.plsql.Loggers.DRIVER_LOG;
import static name.dougmcneil.plsql.Loggers.INIT_LOG;
import static name.dougmcneil.plsql.Loggers.EVENT_LOG;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.netbeans.api.db.explorer.ConnectionListener;
import org.netbeans.api.db.explorer.ConnectionManager;
import org.netbeans.api.db.explorer.DatabaseConnection;
import org.netbeans.api.db.explorer.DatabaseException;
import org.netbeans.api.db.explorer.JDBCDriver;
import org.netbeans.api.db.explorer.JDBCDriverManager;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;
import org.plsql.PLSQLLexer;
import org.plsql.PLSQLParser;
import static org.plsql.PLSQLParser.BEGIN;
import static org.plsql.PLSQLParser.DECLARE;
import static org.plsql.PLSQLParser.END;

/**
 * Controls Driver initialization sequence.
 * If Oracle thin driver is registered and has an URL an attempt to register is made.
 * 
 * @author doug
 */
public final class PLSQLDriver implements ConnectionListener, PropertyChangeListener {
    
    public static final String DRIVER_CLASS = "name.dougmcneil.plsql.jdbc.Driver";
    public static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.OracleDriver";
    public static final String ORACLE_DRIVER_JAR_PROP = "name.dougmcneil.plsql.oracle-jar";
    
    // @todo convert to @Message
    private static final String START_DBMS_OUTPUT = NbBundle.getMessage(
                    PLSQLDriver.class, "start-dbms_output");
    private static final String END_DBMS_OUTPUT = NbBundle.getMessage(
            PLSQLDriver.class, "end-dbms_output");
    private static final String NEW_CONNECTION_MSG = NbBundle.getMessage(
            PLSQLDriver.class, "new-connection_msg");
    private static final String UNKNOWN_CHANGE_MSG = NbBundle.getMessage(
            PLSQLDriver.class, "unknown-change_msg");
    private static final String EVENT_MSG = NbBundle.getMessage(PLSQLDriver.class, "change-event_msg");
    private static final String PLSQL_WINDOW = "PL/SQL-Driver";
    
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
        ERROR_DBMS_OUTPUT,
        /** Recognize request from Driver */
        RECOGNIZE,
        /** Recognize gathering plsql from driver */
        RECOGNIZE_GATHERING,
        /** Recognizer result */
        RECOGNIZER;
        
    }
    
    /** Plugin driver status.
     */
    public static enum Status { 
        /** not yet registered */
        NOT_REGISTERED, 
        /** successfully registered */
        REGISTERED,
        /** cannot register because did not find driver or driver jar */
        NO_DRIVER_OR_NO_JAR,
        /** cannot find or jar */
        NO_PLSQL_JAR, 
        /** NB internal issue */
        CANNOT_CREATE_DRIVER;
    }

    /**
     * Recognizer status
     */
    public enum RecognizerStatus {
        /** naked SQL */
        SQL,
        /** PLSQL recognized */
        PLSQL_BLOCK, 
        /** partial PLSQL recognized */
        PLSQL_BLOCK_INCOMPLETE, 
        /** cannot continue */
        INDETERMINATE
    }
    
    public RecognizerStatus _recognizerStatus;
    
    public static Status _status = Status.NOT_REGISTERED;
    
    private static final PLSQLDriver INSTANCE = new PLSQLDriver();
    
    private DriverChange _changer = new DriverChange();
    
    private InputOutput _io;
    private String _activeIOTitle = "PL/SQL";
    
    
    @SuppressWarnings("LeakingThisInConstructor")
    private PLSQLDriver() {
        // start listening to Driver/Connections 
        // @todo might refine to specify what properties to listen to
        _changer.addPropertyChangeListener(CommProperties.NEW_CONNECTION.name(), this);
        _changer.addPropertyChangeListener(CommProperties.NEW_STATEMENT.name(), this);
        _changer.addPropertyChangeListener(CommProperties.DISCONNECTED.name(), this);
        _changer.addPropertyChangeListener(CommProperties.DBMS_OUTPUT_LINE.name(), this);
        _changer.addPropertyChangeListener(CommProperties.ERROR_DBMS_OUTPUT.name(), this);
        _changer.addPropertyChangeListener(CommProperties.RECOGNIZE.name(), this);
        _changer.addPropertyChangeListener(CommProperties.RECOGNIZE_GATHERING.name(), this);
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
        RecognizerStatus status;
        switch (CommProperties.valueOf(evt.getPropertyName())) {
            case DBMS_OUTPUT_LINE:
                _io = IOProvider.getDefault().getIO(_activeIOTitle, false);
                InputOutput io = IOProvider.getDefault().getIO(PLSQL_WINDOW, false);
                _io.getOut().println(START_DBMS_OUTPUT);
               io.getOut().println(START_DBMS_OUTPUT);
                
                String[] output = (String []) evt.getNewValue();
                for (String line: output) {
                    _io.getOut().println(String.format("%s", line));
                    io.getOut().println(String.format("%s", line));
                }
                _io.getOut().println(END_DBMS_OUTPUT);
                io.getOut().println(END_DBMS_OUTPUT);
                break;
            case NEW_CONNECTION:
                IOProvider.getDefault().getIO(PLSQL_WINDOW, false).getOut().println(
                        String.format(NEW_CONNECTION_MSG, evt.getNewValue()));
                break;
            case NEW_STATEMENT:
                break;
            case DISCONNECTED:
                IOProvider.getDefault().getIO(PLSQL_WINDOW, false).getOut().println();
                break;
            case RECOGNIZE:
                status = recognizer((String) evt.getNewValue());
                postRecognize(status, evt);
                break;
            case RECOGNIZE_GATHERING:
                status = recognizerPLSQL((String) evt.getNewValue());
                postRecognize(status, evt);
                break;
            case ERROR_DBMS_OUTPUT:
                EVENT_LOG.log(Level.INFO, String.format(EVENT_MSG, evt.getPropertyName(),
                        evt.getNewValue()));
                break;
            default:
                EVENT_LOG.log(Level.WARNING, String.format(UNKNOWN_CHANGE_MSG, evt.getPropertyName()));
                break;
        }
    }
    
    public void setIO(String title) {
        _activeIOTitle = title;
    }
    
    private void postRecognize(RecognizerStatus status, PropertyChangeEvent evt) {
        if (status == RecognizerStatus.PLSQL_BLOCK) {
            IOProvider.getDefault().getIO(PLSQL_WINDOW, false).getOut().println((String) evt.getNewValue());
        }
        _changer.firePropertyChange(CommProperties.RECOGNIZER.name(), evt.getOldValue(), 
                status.name());
    }
    
    // When plsql driver is first created (or found on startup) it must be integrated with NetBeans
    private void initDriver(JDBCDriver driver) {
        try {
            Properties props = new Properties();
            props.put(CommProperties.DRIVER_CHANGER.name(), _changer);
            props.put(CommProperties.DRIVER_LOGGER.name(), DRIVER_LOG);
            props.put(CommProperties.EVENT_LOGGER.name(), EVENT_LOG);
            props.put(CommProperties.INIT_LOGGER, INIT_LOG);
            driver.getDriver().connect(name.dougmcneil.plsql.jdbc.Driver.INIT_URL, props);
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
    
    private RecognizerStatus recognizer(String candidate) {
        // order of likeliness
        _recognizerStatus = RecognizerStatus.INDETERMINATE;
        if (recognizeSQL(candidate)) {
            _recognizerStatus = RecognizerStatus.SQL;
        } else if (recognizePLSQLBlock(candidate)) {
            return _recognizerStatus;
        }
        return _recognizerStatus;
    }
    
    private RecognizerStatus recognizerPLSQL(String candidate) {
        recognizePLSQLBlock(candidate);
        return _recognizerStatus;
    }
    
    private boolean recognizeSQL(String candidate) {
        try {
            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(candidate);
            TokenStream tokens = new CommonTokenStream(new PLSQLLexer(input));

            PLSQLParser parser = new PLSQLParser(tokens);
            PLSQLParser.sql_statement_return rtn = parser.sql_statement();
            
            CommonTree tree = (CommonTree) rtn.getTree();
            if (tree.getChildCount() > 0) {
                return true;
            }
            
            return false;
            
        } catch (RecognitionException ex) {
            return false;
        }
    }
    private boolean recognizePLSQLBlock(String candidate) {
        try {
            //lexer splits input into tokens
            ANTLRStringStream input = new ANTLRStringStream(candidate);
            TokenStream tokens = new CommonTokenStream(new PLSQLLexer(input));

            PLSQLParser parser = new PLSQLParser(tokens);
            PLSQLParser.plsql_block_return rtn = parser.plsql_block();
            
            CommonTree tree = (CommonTree) rtn.getTree();
            if (tree.getChildCount() > 0) {
                List<CommonTree> children = tree.getChildren();
                SparseArray full = getLeftSparse(children);
                if (BEGIN_END.equals(full) || DECLARE_BEGIN_END.equals(full)) {
                    _recognizerStatus = RecognizerStatus.PLSQL_BLOCK;
                } else {
                    _recognizerStatus = RecognizerStatus.PLSQL_BLOCK_INCOMPLETE;
                    return false;
                }
            } else {
                _recognizerStatus = RecognizerStatus.PLSQL_BLOCK_INCOMPLETE;
                return false;
            }
            return true;
            
        } catch (RecognitionException ex) {
            _recognizerStatus = RecognizerStatus.INDETERMINATE;
            return false;
        }
    }
    
    private final SparseArray getLeftSparse(List<CommonTree> children) {
        int[] ints = new int[children.size()];
        int i = 0;
        for(CommonTree tree: children) {
            ints[i] = tree.getType();
            i++;
        }
        return new SparseArray(ints);
    }
    
    private static final class SparseArray {
        
        final int[] _array;

        public SparseArray(int[] array) {
            _array = array;
        }
        
        @Override
        public boolean equals(Object alien) {
            if (!(alien instanceof SparseArray)) {
                return false;
            }
            int [] other = ((SparseArray) alien)._array;
            if (other.length < _array.length) {
                return false;
            }
            if (_array[0] != other[0]) {
                return false;
            }
            if (_array[_array.length - 1] != other[other.length - 1]) {
                return false;
            }
            
            for (int i= 1, j = 1; i < _array.length - 1; i++) {
                for (;j < other.length -1; j++) {
                    if (_array[i] == other[j]) {
                        j++;
                        break;
                    }
                }
                if (j == other.length) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int hash = _array.hashCode();
            return hash;
        }
        
    }
    
    private static final SparseArray BEGIN_END = new SparseArray(new int[] {BEGIN, END});
    private static final SparseArray DECLARE_BEGIN_END = 
            new SparseArray(new int[] {DECLARE, BEGIN, END});
}
