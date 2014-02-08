/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql;

import java.util.logging.Logger;

/**
 *
 * @author doug
 */
public class Loggers {
    public static final Logger INIT_LOG = Logger.getLogger("plsql-init");
    
    public static final Logger EVENT_LOG = Logger.getLogger("plsql-event");
    
    public static final Logger DRIVER_LOG = Logger.getLogger("plsql-driver");
    
    public static final String EVENT_MSG = "Change event: %s -> %s";
}
