/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import name.dougmcneil.plsql.sql.Driver;
import static name.dougmcneil.plsql.Loggers.INIT_LOG;
import org.netbeans.spi.db.explorer.DatabaseRuntime;

/**
 * Implementation of DatabaseRuntime to control registering of wrapped oracle driver.
 * @author doug
 */
public class PLSQLRegister implements DatabaseRuntime {

    private boolean _started;
    
    @Override
    public String getJDBCDriverClass() {
        return Driver.DRIVER_CLASS;
    }

    
    @Override
    public boolean acceptsDatabaseURL(String string) {
        return string.startsWith("jdbc:thin:plsql");
    }

    @Override
    public boolean isRunning() {
        return _started;
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void stop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
