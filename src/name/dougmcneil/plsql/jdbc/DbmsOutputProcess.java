/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.jdbc;

import java.beans.PropertyChangeSupport;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import static name.dougmcneil.plsql.PLSQLDriver.CommProperties.DBMS_OUTPUT_LINE;
import static name.dougmcneil.plsql.PLSQLDriver.CommProperties.ERROR_DBMS_OUTPUT;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Event.BEGIN;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Event.END;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Event.EXECUTE;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Event.POST;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Status.START;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Status.READY;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Status.PRINTED;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Status.FAILED;
import static name.dougmcneil.plsql.jdbc.DbmsOutputProcess.Status.COMPLETE;

import org.openide.util.Exceptions;

/**
 * DBMS_OUTPUT state machine.
 * 
 * @author doug
 */
class DbmsOutputProcess {
    private static final String ENABLE_ERROR_MSG = "Error: DBMS_OUTPUT.ENABLE(NULL), %s";
    private static final String DISABLE_ERROR_MSG = "Error: DBMS_OUTPUT.DISABLE, %s";

    enum Status {

        START, READY, PRINTED, FAILED, COMPLETE
    }

    enum Event {

        BEGIN, EXECUTE, POST, END
    }
    private PropertyChangeSupport _pcs;
    private Connection _connection;
    private Status _status;
    private final String _name;

    DbmsOutputProcess(PropertyChangeSupport pcs, Connection connection, String name) {
        _name = name;
        _pcs = pcs;
        _connection = connection;
        _status = Status.START;
    }

    /**
     * Perform transitions based on event.
     * @param event marking transition
     * @return what status transitioned to
     */
    public Status event(Event event) {
        switch (_status) {
            case START:
                if (event != BEGIN) {
                    break;
                }
                if (enable()) {
                    _status = READY;
                } else {
                    disable();
                    _status = FAILED;
                }
                break;
            case READY:
                if (event == END) {
                    _status = COMPLETE;
                    break;
                }
                if (event != EXECUTE) {
                    break;
                }
                print();
                _status = PRINTED;
                break;
            case PRINTED:
                if (event == END) {
                    _status = COMPLETE;
                    break;
                }
                if (event == POST) {
                    _status = Status.READY;
                    break;
                }
                if (event != EXECUTE) {
                    break;
                }
                print();
                break;
            case FAILED:
                if (event == END) {
                    _status = COMPLETE;
                    break;
                }
                if (event == POST) {
                    _status = READY;
                }
                break;
            case COMPLETE:
                break;
        }
        return _status;
    }

    private boolean enable() {
        // idempotent
        try {
            _connection.prepareCall("begin dbms_output.enable(null); end;").execute();
            return true;
        } catch (SQLException ex) {
            _pcs.firePropertyChange(ERROR_DBMS_OUTPUT.name(), null,
                    String.format(ENABLE_ERROR_MSG, ex.toString()));
            return false;
        }
    }

    private boolean disable() {
        // idempotent
        try {
            _connection.prepareCall("begin dbms_output.disable; end;").execute();
            return true;
        } catch (SQLException ex) {
            _pcs.firePropertyChange(ERROR_DBMS_OUTPUT.name(), null, 
                    String.format(DISABLE_ERROR_MSG, ex.toString()));
            return false;
        }
    }

    private void print() {
        // print is idempotent, it will not re-print, etc.
        try {
            String getLineSql = "begin dbms_output.get_line(?,?); end;";
            CallableStatement stmt = _connection.prepareCall(getLineSql);
            boolean hasMore = true;
            stmt.registerOutParameter(1, Types.VARCHAR);
            stmt.registerOutParameter(2, Types.INTEGER);
            List<String> strings = new ArrayList<String>();
            while (hasMore) {
                boolean status = stmt.execute();
                hasMore = (stmt.getInt(2) == 0);
                if (hasMore) {
                    strings.add(stmt.getString(1));
                }
            }
            if (strings.size() > 0) {
                String[] t = strings.toArray(new String[strings.size()]);
                _pcs.firePropertyChange(DBMS_OUTPUT_LINE.name(), null, t);
            }
            stmt.close();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
}
