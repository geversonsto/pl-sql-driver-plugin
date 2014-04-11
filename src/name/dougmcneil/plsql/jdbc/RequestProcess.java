/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.jdbc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.CallableStatement;
import java.sql.SQLException;
import name.dougmcneil.plsql.PLSQLDriver.CommProperties;
import name.dougmcneil.plsql.PLSQLDriver.RecognizerStatus;
import name.dougmcneil.plsql.jdbc.Driver.PLSQLStatement;
import static name.dougmcneil.plsql.jdbc.RequestProcess.Event.END;
import static name.dougmcneil.plsql.jdbc.RequestProcess.Event.EXECUTE;


/**
 * JDBC Request process.
 * 
 * @author doug
 */
class RequestProcess implements PropertyChangeListener {

    private final PropertyChangeSupport _pcs;
    private PLSQLStatement _statement;
    
    private final Long _id = System.currentTimeMillis();
    
    private RequestAbst _request = new BeginRequest();
    
    // time gathering sessions
    private long _timer;
    
    enum Status {

        READY, GATHERING, RECOGNIZED, EXECUTED
    }

    enum Event {

        EXECUTE, POST, END
    }
    
    private Status _status = Status.READY;
    
    RequestProcess(PropertyChangeSupport pcs) {
        _pcs = pcs;
        _pcs.addPropertyChangeListener(CommProperties.RECOGNIZER.name(), this);
    }
    
    void setStatement(PLSQLStatement statement) {
        _statement = statement;
    }

    /**
     * Perform transitions based on event.
     * @param event marking transition
     * @return what status transitioned to
     */
    public Status event(Event event) {
        switch (_status) {
            case READY:
                _timer = System.currentTimeMillis();
                _request = new BeginRequest();
                if (event != EXECUTE) {
                    break;
                }
                _pcs.firePropertyChange(CommProperties.RECOGNIZE.name(), _id,
                        _request.appendCandidate(_statement.getCandidate()));
                break;
            case GATHERING:
                if (event != EXECUTE) {
                    break;
                }
                if ((System.currentTimeMillis() - _timer) > 1000) {
                    // timeout reset
                    reset();
                    return event(event);
                }
                _pcs.firePropertyChange(CommProperties.RECOGNIZE_GATHERING.name(), _id,
                        _request.appendCandidate(_statement.getCandidate()));
                break;
            case EXECUTED:
                if (event == END) {
                    reset();
                }
                break;
        }
        return _status;
    }
    
    // cleanup
    private void reset() {
        _request.close();
        _request = new BeginRequest();
        _status = Status.READY;
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (CommProperties.valueOf(evt.getPropertyName())) {
            case RECOGNIZER:
                Long id = (Long) evt.getOldValue();
                String output = (String) evt.getNewValue();
                if (id.equals(_id) ) {
                    _status = _request.processRecognizer(output);
                }
                break;
        }
    }

    boolean execute(String sql) throws SQLException {
        switch (_status) {
            case RECOGNIZED:
                return _request.execute(sql);
            case GATHERING:
                return false;
                
            default:
                    return false;
        }
    }

    
    // responsible for executing a request and handling down stream consequences
    private abstract class RequestAbst {
        
        protected String _candidate = "";
        
        String appendCandidate(String candidate) {
            _candidate = new StringBuilder(_candidate).append(candidate).append(";\n").toString();
            return _candidate;
        }
        
        Status processRecognizer(String result) {
            return _status;
        }
        
        boolean execute(String sql) throws SQLException {
            return false;
        }
        
        void close() {
        }
        
    }
    
    private class BeginRequest extends RequestAbst {
        @Override
        Status processRecognizer(String result) {
            Status status = _status;
            switch(RecognizerStatus.valueOf(result)) {
                case SQL:
                    _request = new SQLRequest();
                    status = Status.RECOGNIZED;
                    break;
                case PLSQL_BLOCK:
                    _request = new PLSQLBlockRequest();
                    status = Status.RECOGNIZED;
                    break;
                case PLSQL_BLOCK_INCOMPLETE:
                    _request = new PLSQLBlockRequest(_request._candidate);
                    status = Status.GATHERING;
                    break;
                case INDETERMINATE:
                    reset();
                    break;
                    
            }
            return status;
        }
        
    }
    
    private class SQLRequest extends RequestAbst {
        
        @Override
        boolean execute(String sql) throws SQLException {
            _status = Status.EXECUTED;
            return _statement._wrapper.execute(sql);
        }
    }
    
    private class PLSQLBlockRequest extends RequestAbst {
        private CallableStatement _cStatement;

        public PLSQLBlockRequest() {
        }
        
        public PLSQLBlockRequest(String candidate) {
            super();
            _candidate = candidate;
        }
        
        
        @Override
        Status processRecognizer(String result) {
            Status status = _status;
            switch(RecognizerStatus.valueOf(result)) {
                case PLSQL_BLOCK:
                    status = Status.RECOGNIZED;
                    break;
                case PLSQL_BLOCK_INCOMPLETE:
                    status = Status.GATHERING;
                    break;
                    
            }
            return status;
        }
        @Override
        boolean execute(String sql) throws SQLException {
            _status = Status.EXECUTED;
            _cStatement = _statement._connection.prepareCall(_candidate);
            return _cStatement.execute();
        }
        
        @Override
        void close() {
            if (_cStatement != null) {
                try {
                    _cStatement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
    
}
