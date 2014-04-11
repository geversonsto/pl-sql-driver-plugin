/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.dougmcneil.plsql.jdbc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverPropertyInfo;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.sql.Types;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import static name.dougmcneil.plsql.Loggers.EVENT_MSG;
import static name.dougmcneil.plsql.PLSQLDriver.CommProperties;
import static name.dougmcneil.plsql.PLSQLDriver.CommProperties.DRIVER_CHANGER;
import static name.dougmcneil.plsql.PLSQLDriver.CommProperties.NEW_CONNECTION;
import static name.dougmcneil.plsql.PLSQLDriver.ORACLE_DRIVER_CLASS;
import static name.dougmcneil.plsql.PLSQLDriver.ORACLE_DRIVER_JAR_PROP;
import org.openide.util.Exceptions;

/**
 * Implementation of Driver. 
 * @author doug
 */
public class Driver implements java.sql.Driver, PropertyChangeListener {
    public static final String DRIVER_CLASS = "name.dougmcneil.plsql.jdbc.Driver";
    public static final String INIT_URL = "jdbc:plsql:init";
    
    private static Logger INIT_LOG = name.dougmcneil.plsql.Loggers.INIT_LOG;
    private static Logger EVENT_LOG = name.dougmcneil.plsql.Loggers.EVENT_LOG;
    private static Logger DRIVER_LOG = name.dougmcneil.plsql.Loggers.DRIVER_LOG;
    
    private java.sql.Driver _wrapped;
    private java.sql.Driver _oci;
    private java.sql.Driver _thin;
    
    private final String _oracleJarLocation;
    
    private static PropertyChangeSupport _changer;
    
    public Driver() {
        _oracleJarLocation = System.getProperty(ORACLE_DRIVER_JAR_PROP);
        try {
            DbURLClassLoader loader;
            loader = new DbURLClassLoader(new URL[] { new URL(_oracleJarLocation)});
            Class<java.sql.Driver> klass = (Class<java.sql.Driver>)
                    loader.loadClass(ORACLE_DRIVER_CLASS);
            _wrapped = klass.newInstance();
        } catch (MalformedURLException ex) {
            INIT_LOG.log(Level.SEVERE, "Cannot load oracle driver", ex);
        } catch (ClassNotFoundException ex) {
            INIT_LOG.log(Level.SEVERE, "Cannot load oracle driver", ex);
        } catch (InstantiationException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IllegalAccessException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (INIT_URL.equals(url)) {
            init(info);
            return null;
        }
        return new PLSQLConnection(url, _wrapped.connect(url, info), _changer);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        // convert to oracle url
        return _wrapped.acceptsURL(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return _wrapped.getPropertyInfo(url, info);
    }

    @Override
    public int getMajorVersion() {
        return _wrapped.getMajorVersion();
    }

    @Override
    public int getMinorVersion() {
        return _wrapped.getMinorVersion();
    }

    @Override
    public boolean jdbcCompliant() {
        return _wrapped.jdbcCompliant();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return INIT_LOG;
    }
    
    // when setup all communication with PLSQL NetBeans layer happens through here
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EVENT_LOG.log(Level.FINER, String.format(EVENT_MSG, evt.getPropertyName(), evt.getOldValue()));
    }
    
    // init base on properties passed from PLSQLDriver
    private void init(Properties props) {
        _changer = (PropertyChangeSupport) props.get(DRIVER_CHANGER.name());
        INIT_LOG = (Logger) props.get(CommProperties.INIT_LOGGER.name());
        EVENT_LOG = (Logger) props.get(CommProperties.EVENT_LOGGER.name());
        DRIVER_LOG = (Logger) props.get(CommProperties.DRIVER_LOGGER.name());
        //_changer.addPropertyChangeListener(this);
    }

    private static class PLSQLConnection implements Connection {
        
        private static final String NAME_MSG = "%s :- %s";
        
        private final String _name;
        
        private final String _url;
        private final Connection _wrapper;
        private final PropertyChangeSupport _changer;
        private final DbmsOutputProcess _dbmsOutput;
        private RequestProcess _request;
        private PLSQLConnection(String url, Connection wrapper, PropertyChangeSupport changer) {
            _url = url;
            _wrapper = wrapper;
            _changer = changer;
            String name;
            try {
                name = String.format(NAME_MSG,url, getSchema());
                _changer.firePropertyChange(NEW_CONNECTION.name(), null, name);
            } catch (SQLException ex) {
                name = "unknown";
            }
            _name = name;
            _request = new RequestProcess(_changer);
            _dbmsOutput = new DbmsOutputProcess(changer, wrapper, _name);
            _dbmsOutput.event(DbmsOutputProcess.Event.BEGIN);
        }
        
        @Override
        public Statement createStatement() throws SQLException {
            return new PLSQLStatement(_wrapper, _wrapper.createStatement(), _changer, _request,
                    _dbmsOutput,  _name);
        }

        @Override
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return _wrapper.prepareStatement(sql);
        }

        @Override
        public CallableStatement prepareCall(String sql) throws SQLException {
            return _wrapper.prepareCall(sql);
        }

        @Override
        public String nativeSQL(String sql) throws SQLException {
            return _wrapper.nativeSQL(sql);
        }

        @Override
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            _wrapper.setAutoCommit(autoCommit);
        }

        @Override
        public boolean getAutoCommit() throws SQLException {
            return _wrapper.getAutoCommit();
        }

        @Override
        public void commit() throws SQLException {
            _wrapper.commit();
            _dbmsOutput.event(DbmsOutputProcess.Event.POST);
        }

        @Override
        public void rollback() throws SQLException {
            _wrapper.rollback();
            _dbmsOutput.event(DbmsOutputProcess.Event.POST);
        }

        @Override
        public void close() throws SQLException {
            _wrapper.close();
            if (_wrapper.isClosed()) {
                _changer.firePropertyChange(CommProperties.DISCONNECTED.name(), null, _name);
                _dbmsOutput.event(DbmsOutputProcess.Event.END);
            }
        }

        @Override
        public boolean isClosed() throws SQLException {
            return _wrapper.isClosed();
        }

        @Override
        public DatabaseMetaData getMetaData() throws SQLException {
            return _wrapper.getMetaData();
        }

        @Override
        public void setReadOnly(boolean readOnly) throws SQLException {
            _wrapper.setReadOnly(readOnly);
        }

        @Override
        public boolean isReadOnly() throws SQLException {
            return _wrapper.isReadOnly();
        }

        @Override
        public void setCatalog(String catalog) throws SQLException {
            _wrapper.setCatalog(catalog);
        }

        @Override
        public String getCatalog() throws SQLException {
            return _wrapper.getCatalog();
        }

        @Override
        public void setTransactionIsolation(int level) throws SQLException {
            _wrapper.setTransactionIsolation(level);
        }

        @Override
        public int getTransactionIsolation() throws SQLException {
            return _wrapper.getTransactionIsolation();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return _wrapper.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            _wrapper.clearWarnings();
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
            return new PLSQLStatement(_wrapper, _wrapper.createStatement(resultSetType, resultSetConcurrency),
                    _changer, _request, _dbmsOutput, _name);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return _wrapper.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
            return _wrapper.prepareCall(sql, resultSetType, resultSetConcurrency);
        }

        @Override
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return _wrapper.getTypeMap();
        }

        @Override
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            _wrapper.setTypeMap(map);
        }

        @Override
        public void setHoldability(int holdability) throws SQLException {
            _wrapper.setHoldability(holdability);
        }

        @Override
        public int getHoldability() throws SQLException {
            return _wrapper.getHoldability();
        }

        @Override
        public Savepoint setSavepoint() throws SQLException {
            return _wrapper.setSavepoint();
        }

        @Override
        public Savepoint setSavepoint(String name) throws SQLException {
            return _wrapper.setSavepoint(name);
        }

        @Override
        public void rollback(Savepoint savepoint) throws SQLException {
            _wrapper.rollback(savepoint);
        }

        @Override
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            _wrapper.releaseSavepoint(savepoint);
        }

        @Override
        public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return _wrapper.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return _wrapper.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
            return _wrapper.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
            return _wrapper.prepareStatement(sql, autoGeneratedKeys);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
            return _wrapper.prepareStatement(sql, columnIndexes);
        }

        @Override
        public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
            return _wrapper.prepareStatement(sql, columnNames);
        }

        @Override
        public Clob createClob() throws SQLException {
            return _wrapper.createClob();
        }

        @Override
        public Blob createBlob() throws SQLException {
            return _wrapper.createBlob();
        }

        @Override
        public NClob createNClob() throws SQLException {
            return _wrapper.createNClob();
        }

        @Override
        public SQLXML createSQLXML() throws SQLException {
            return _wrapper.createSQLXML();
        }

        @Override
        public boolean isValid(int timeout) throws SQLException {
            return _wrapper.isValid(timeout);
        }

        @Override
        public void setClientInfo(String name, String value) throws SQLClientInfoException {
            _wrapper.setClientInfo(name, value);
        }

        @Override
        public void setClientInfo(Properties properties) throws SQLClientInfoException {
            _wrapper.setClientInfo(properties);
        }

        @Override
        public String getClientInfo(String name) throws SQLException {
            return _wrapper.getClientInfo(name);
        }

        @Override
        public Properties getClientInfo() throws SQLException {
            return _wrapper.getClientInfo();
        }

        @Override
        public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
            return _wrapper.createArrayOf(typeName, elements);
        }

        @Override
        public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
            return _wrapper.createStruct(typeName, attributes);
        }

        @Override
        public void setSchema(String schema) throws SQLException {
            _wrapper.setSchema(schema);
        }

        @Override
        public String getSchema() throws SQLException {
            return _wrapper.getSchema();
        }

        @Override
        public void abort(Executor executor) throws SQLException {
            _wrapper.abort(executor);
        }

        @Override
        public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
            _wrapper.setNetworkTimeout(executor, milliseconds);
        }

        @Override
        public int getNetworkTimeout() throws SQLException {
            return _wrapper.getNetworkTimeout();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return _wrapper.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return _wrapper.isWrapperFor(iface);
        }
        
    }
    
    static class PLSQLStatement implements Statement {
        
        private static int _statementCount;
        private final DbmsOutputProcess _dbmsOutput;
        private final RequestProcess _request;
        private final String _connectionName;
        private String _candiate;
        final Statement _wrapper;
        final Connection _connection;
        
        private PLSQLStatement(Connection connection, Statement wrapper, 
                PropertyChangeSupport changer, RequestProcess request,
                DbmsOutputProcess dbmsOutput, String connectionName) {
            _connectionName = connectionName;
            _statementCount++;
            _connection = connection;
            _wrapper = wrapper;
            _dbmsOutput = dbmsOutput;
            _request = request;
            _request.setStatement(this);
            changer.firePropertyChange(CommProperties.NEW_STATEMENT.name(), null, _statementCount);
        }

        String getCandidate() {
            return _candiate;
        }

        @Override
        public ResultSet executeQuery(String sql) throws SQLException {
            _candiate = sql;
            try {
                //_request.event(RequestProcess.Event.EXECUTE);
                return _wrapper.executeQuery(sql);
            } finally {
                _dbmsOutput.event(DbmsOutputProcess.Event.EXECUTE);
            }
        }

        @Override
        public int executeUpdate(String sql) throws SQLException {
            _candiate = sql;
            try {
                return _wrapper.executeUpdate(sql);
            } finally {
                _dbmsOutput.event(DbmsOutputProcess.Event.EXECUTE);
            }
        }

        @Override
        public void close() throws SQLException {
            _request.event(RequestProcess.Event.END);
            _wrapper.close();
        }

        @Override
        public int getMaxFieldSize() throws SQLException {
            return _wrapper.getMaxFieldSize();
        }

        @Override
        public void setMaxFieldSize(int max) throws SQLException {
            _wrapper.setMaxFieldSize(max);
        }

        @Override
        public int getMaxRows() throws SQLException {
            return _wrapper.getMaxRows();
        }

        @Override
        public void setMaxRows(int max) throws SQLException {
            _wrapper.setMaxRows(max);
        }

        @Override
        public void setEscapeProcessing(boolean enable) throws SQLException {
            _wrapper.setEscapeProcessing(enable);
        }

        @Override
        public int getQueryTimeout() throws SQLException {
            return _wrapper.getQueryTimeout();
        }

        @Override
        public void setQueryTimeout(int seconds) throws SQLException {
            _wrapper.setQueryTimeout(seconds);
        }

        @Override
        public void cancel() throws SQLException {
            _wrapper.cancel();
        }

        @Override
        public SQLWarning getWarnings() throws SQLException {
            return _wrapper.getWarnings();
        }

        @Override
        public void clearWarnings() throws SQLException {
            _wrapper.clearWarnings();
        }

        @Override
        public void setCursorName(String name) throws SQLException {
            _wrapper.setCursorName(name);
        }

        @Override
        public boolean execute(String sql) throws SQLException {
            _candiate = sql;
            try {
                // @todo calls could be combined
                _request.event(RequestProcess.Event.EXECUTE);
                return _request.execute(sql);
            } finally {
                _dbmsOutput.event(DbmsOutputProcess.Event.EXECUTE);
            }
        }

        @Override
        public ResultSet getResultSet() throws SQLException {
            try {
                return _wrapper.getResultSet();
            } finally {
                _dbmsOutput.event(DbmsOutputProcess.Event.POST);
            }
        }

        @Override
        public int getUpdateCount() throws SQLException {
            try {
                return _wrapper.getUpdateCount();
            } finally {
                _dbmsOutput.event(DbmsOutputProcess.Event.POST);
            }
        }

        @Override
        public boolean getMoreResults() throws SQLException {
            return _wrapper.getMoreResults();
        }

        @Override
        public void setFetchDirection(int direction) throws SQLException {
            _wrapper.setFetchDirection(direction);
        }

        @Override
        public int getFetchDirection() throws SQLException {
            return _wrapper.getFetchDirection();
        }

        @Override
        public void setFetchSize(int rows) throws SQLException {
            _wrapper.setFetchSize(rows);
        }

        @Override
        public int getFetchSize() throws SQLException {
            return _wrapper.getFetchSize();
        }

        @Override
        public int getResultSetConcurrency() throws SQLException {
            return _wrapper.getResultSetConcurrency();
        }

        @Override
        public int getResultSetType() throws SQLException {
            return _wrapper.getResultSetType();
        }

        @Override
        public void addBatch(String sql) throws SQLException {
            _wrapper.addBatch(sql);
        }

        @Override
        public void clearBatch() throws SQLException {
            _wrapper.clearBatch();
        }

        @Override
        public int[] executeBatch() throws SQLException {
            return _wrapper.executeBatch();
        }

        @Override
        public Connection getConnection() throws SQLException {
            return _wrapper.getConnection();
        }

        @Override
        public boolean getMoreResults(int current) throws SQLException {
            return _wrapper.getMoreResults(current);
        }

        @Override
        public ResultSet getGeneratedKeys() throws SQLException {
            return _wrapper.getGeneratedKeys();
        }

        @Override
        public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
            return _wrapper.executeUpdate(sql, autoGeneratedKeys);
        }

        @Override
        public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
            return _wrapper.executeUpdate(sql, columnIndexes);
        }

        @Override
        public int executeUpdate(String sql, String[] columnNames) throws SQLException {
            return _wrapper.executeUpdate(sql, columnNames);
        }

        @Override
        public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
            return _wrapper.execute(sql, autoGeneratedKeys);
        }

        @Override
        public boolean execute(String sql, int[] columnIndexes) throws SQLException {
            return _wrapper.execute(sql, columnIndexes);
        }

        @Override
        public boolean execute(String sql, String[] columnNames) throws SQLException {
            return _wrapper.execute(sql, columnNames);
        }

        @Override
        public int getResultSetHoldability() throws SQLException {
            return _wrapper.getResultSetHoldability();
        }

        @Override
        public boolean isClosed() throws SQLException {
            return _wrapper.isClosed();
        }

        @Override
        public void setPoolable(boolean poolable) throws SQLException {
            _wrapper.setPoolable(poolable);
        }

        @Override
        public boolean isPoolable() throws SQLException {
            return _wrapper.isPoolable();
        }

        @Override
        public void closeOnCompletion() throws SQLException {
            _wrapper.closeOnCompletion();
        }

        @Override
        public boolean isCloseOnCompletion() throws SQLException {
            return _wrapper.isCloseOnCompletion();
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return _wrapper.unwrap(iface);
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return _wrapper.isWrapperFor(iface);
        }
    
    }
    
    private static class DbURLClassLoader extends URLClassLoader {

        /** Creates a new instance of DbURLClassLoader */
        public DbURLClassLoader(URL[] urls) {
            super(urls);
        }

        @Override
        protected PermissionCollection getPermissions(CodeSource codesource) {
            Permissions permissions = new Permissions();
            permissions.add(new AllPermission());
            permissions.setReadOnly();

            return permissions;
        }

        @Override
        public String toString() {
            return "DbURLClassLoader[urls=" + Arrays.asList(getURLs()) + "]"; // NOI18N
        }
    }
}
