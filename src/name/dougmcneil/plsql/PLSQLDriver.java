/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import static name.dougmcneil.plsql.Loggers.INIT_LOG;
import name.dougmcneil.plsql.sql.Driver;
import org.netbeans.api.db.explorer.DatabaseException;
import org.netbeans.api.db.explorer.JDBCDriver;
import org.netbeans.api.db.explorer.JDBCDriverManager;
import org.netbeans.modules.db.explorer.DbDriverManager;
import org.openide.filesystems.FileSystem;
import org.openide.filesystems.FileUtil;
import org.openide.util.Exceptions;

/**
 * Controls Driver.
 * 
 * @author doug
 */
final public class PLSQLDriver {
    
    public static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    
    private static final PLSQLDriver INSTANCE = new PLSQLDriver();
    
    private String _jarPath;
    
    private static boolean _registered;
    
    private PLSQLDriver() {
    }
    
    public static PLSQLDriver getInstance() {
        return INSTANCE;
    }
    
    public void setJarPath(String jarPath) {
        _jarPath = jarPath;
    }
    
    /**
     * Initialize driver (register)
     */
    public void init() {
        if (_registered) {
            return;
        }
        try {
            FileUtil.runAtomicAction(new FileSystem.AtomicAction() {

                public void run() {
                    registerDriver();
                }
            });
        } catch (IOException e) {
            Exceptions.printStackTrace(e);
        }
    }
    
    private static void registerDriver() {
        JDBCDriver[] drivers = JDBCDriverManager.getDefault().getDrivers(ORACLE_DRIVER_CLASS);
        for (JDBCDriver driver: drivers) {
            URL[] urls = driver.getURLs();
            if (urls.length > 0) {
                URL url = urls[0];
            }
        }
        try {
            JDBCDriver newDriver = JDBCDriver.create("plsql_wrapper", "PLSQL Wrapping Driver", Driver.DRIVER_CLASS, new URL[]{});
            JDBCDriverManager.getDefault().addDriver(newDriver);
            _registered = true;
         } catch (DatabaseException e) {
            INIT_LOG.log(Level.WARNING, null, e);
        }
        
    }
    
}
