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
import java.util.regex.Pattern;
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
    
    private String[][] _parameters;
    
    enum Status {

        READY, GATHERING, RECOGNIZED, EXECUTED
    }

    enum Event {

        EXECUTE, POST, END
    }
    
    private Status _status = Status.READY;
    
    RequestProcess(final PropertyChangeSupport pcs) {
        _pcs = pcs;
        _pcs.addPropertyChangeListener(CommProperties.RECOGNIZER.name(), this);
        _pcs.addPropertyChangeListener(CommProperties.PARAMETERS.name(), this);
    }
    
    void setStatement(final PLSQLStatement statement) {
        _statement = statement;
    }

    /**
     * Perform transitions based on event.
     * @param event marking transition
     * @return what status transitioned to
     */
    public Status event(final Event event) {
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
    public void propertyChange(final PropertyChangeEvent evt) {
        switch (CommProperties.valueOf(evt.getPropertyName())) {
            case RECOGNIZER:
                Long id = (Long) evt.getOldValue();
                String output = (String) evt.getNewValue();
                if (id.equals(_id) ) {
                    _status = _request.processRecognizer(output);
                }
                break;
            case PARAMETERS:
               _request.setSubstituted((String) evt.getNewValue());
                break;
        }
    }

    boolean execute(final String sql) throws SQLException {
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
        
        String appendCandidate(final String candidate) {
            _candidate = new StringBuilder(_candidate).append(candidate).append(";\n").toString();
            return _candidate;
        }
        
        Status processRecognizer(final String result) {
            return _status;
        }
        
        boolean execute(final String sql) throws SQLException {
            return false;
        }
        
        void setSubstituted(final String sub) {
            _candidate = sub;
        }
        
        void close() {
        }
        
    }
    
    private class BeginRequest extends RequestAbst {
        @Override
        Status processRecognizer(final String result) {
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
        boolean execute(final String sql) throws SQLException {
            _status = Status.EXECUTED;
            _candidate = _candidate.replace(';', ' ');
            _candidate = _candidate.replace('\n', ' ');
            return _statement._wrapper.execute(_candidate.trim());
        }
    }
    
    private class PLSQLBlockRequest extends RequestAbst {
        private CallableStatement _cStatement;

        public PLSQLBlockRequest() {
        }
        
        public PLSQLBlockRequest(final String candidate) {
            super();
            _candidate = candidate;
        }
        
        
        @Override
        Status processRecognizer(final String result) {
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
        boolean execute(final String sql) throws SQLException {
            _candidate = _candidate.replaceAll("\\;\\s*\\;", ";");
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
