/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import name.dougmcneil.plsql.sql.Driver;

/**
 * Encapsulates All driver duties.
 * 
 * @author doug
 */
final public class PLSQLDriver {
    
    private static final PLSQLDriver INSTANCE = new PLSQLDriver();
    
    private String _jarPath;
    
    private PLSQLDriver() {
    }
    
    public static PLSQLDriver getInstance() {
        return INSTANCE;
    }
    
    public void setJarPath(String jarPath) {
        _jarPath = jarPath;
    }
    
    public void init(Driver driver) {
        
    }
    
}
