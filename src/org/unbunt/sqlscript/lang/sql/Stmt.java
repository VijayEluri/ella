package org.unbunt.sqlscript.lang.sql;

import org.antlr.runtime.RecognitionException;
import org.unbunt.sqlscript.SQLScriptEngine;
import org.unbunt.sqlscript.ParserHelper;
import org.unbunt.sqlscript.exception.ClosureTerminatedException;
import org.unbunt.sqlscript.exception.SQLScriptRuntimeException;
import org.unbunt.sqlscript.exception.LoopContinueException;
import org.unbunt.sqlscript.exception.LoopBreakException;
import org.unbunt.sqlscript.lang.*;
import org.unbunt.sqlscript.support.Context;
import org.unbunt.sqlscript.support.ProtoRegistry;
import org.unbunt.sqlscript.support.RawParamedSQL;
import org.unbunt.sqlscript.support.NativeWrapper;
import static org.unbunt.sqlscript.utils.ObjUtils.ensureType;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Stmt extends PlainObj {
    public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

    protected RawSQL rawStatement;
    protected RawParamedSQL rawParamedStatement = null;
    protected Statement statement = null;
    protected PreparedStatement preparedStatement = null;
    protected Connection connection;

    protected boolean paramed = false;
    protected Obj[] params = null;
    protected Map<String, Obj> namedParams = null;

    protected boolean keepResources;

    /**
     * Indicates if this Stmt object's resources are to be managed by an external entity.
     */
    protected boolean managedExternal;

    protected boolean initialized = false;

    public Stmt(RawSQL rawStatement, Connection connection, boolean managedExternal) {
        this.rawStatement = rawStatement;
        this.connection = connection;
        this.managedExternal = managedExternal;
        this.keepResources = managedExternal;
    }

    protected void enterManagedMode() {
        if (managedExternal) {
            return;
        }
        keepResources = true;
    }

    protected void leaveManagedMode() throws SQLException {
        if (managedExternal) {
            return;
        }
        keepResources = false;
        close();
    }

    public void leaveExternalManagedMode() throws SQLException {
        managedExternal = false;
        keepResources = false;
        close();
    }

    protected boolean execute() throws SQLException {
        if (paramed) {
            initPrepared();
            addParams();
            return preparedStatement.execute();
        }
        else {
            init();
            return statement.execute(rawStatement.getStatement());
        }
    }

    protected ResultSet query() throws SQLException {
        if (paramed) {
            initPrepared();
            addParams();
            return preparedStatement.executeQuery();
        }
        else {
            init();
            return statement.executeQuery(rawStatement.getStatement());
        }
    }

    protected ResultSet retrieveKeys() throws SQLException {
        if (paramed) {
            initPreparedForKeys();
            addParams();
            preparedStatement.executeUpdate();
            return preparedStatement.getGeneratedKeys();
        }
        else {
            init();
            statement.executeUpdate(rawStatement.getStatement(), Statement.RETURN_GENERATED_KEYS);
            return statement.getGeneratedKeys();
        }
    }

    protected void addBatch(Obj[] params) throws SQLException {
        setParams(params);
        addParams();
        preparedStatement.addBatch();
    }

    protected void addNamedBatch(Obj namedParams) throws SQLException {
        setNamedParams(namedParams);
        addParams();
        preparedStatement.addBatch();
    }

    protected void execBatch() throws SQLException {
        preparedStatement.executeBatch();
    }

    protected void init() throws SQLException {
        if (initialized) {
            if (keepResources) {
                return;
            }
            else {
                throw new SQLScriptRuntimeException("Illegal state");
            }
        }

        // create statement downgrading result set features as nessassary
        try {
            System.err.println("connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)");
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLFeatureNotSupportedException e) {
            try {
                System.err.println("connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)");
                statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLFeatureNotSupportedException e2) {
                System.err.println("connection.createStatement()");
                statement = connection.createStatement();
            }
        }

        initialized = true;
    }

    protected void initPrepared() throws SQLException {
        if (initialized) {
            if (keepResources) {
                return;
            }
            else {
                throw new SQLScriptRuntimeException("Illegal state");
            }
        }

        String sql = getParamedQuery();
        try {
            preparedStatement =
                    connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLFeatureNotSupportedException e) {
            try {
                preparedStatement =
                        connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            } catch (SQLFeatureNotSupportedException e2) {
                preparedStatement = connection.prepareStatement(sql);
            }
        }

        initialized = true;
    }

    protected void initPreparedForKeys() throws SQLException {
        if (initialized) {
            if (keepResources) {
                return;
            }
            else {
                throw new SQLScriptRuntimeException("Illegal state");
            }
        }

        preparedStatement = connection.prepareStatement(getParamedQuery(), Statement.RETURN_GENERATED_KEYS);

        initialized = true;
    }

    protected String getParamedQuery() {
        return rawParamedStatement != null ? rawParamedStatement.getStatement() : rawStatement.getStatement();
    }

    protected void addParams() throws SQLException {
        if (namedParams != null) {
            Map<String, List<Integer>> paramIndices = rawParamedStatement.getParameters();
            for (Map.Entry<String, Obj> entry : namedParams.entrySet()) {
                List<Integer> indices = paramIndices.get(entry.getKey());
                for (Integer index : indices) {
                    // TODO: Handle Null type hint
                    preparedStatement.setObject(index, entry.getValue().toJavaObject());
                }
            }
        }
        else {
            int nparams = params.length;
            for (int i = 0; i < nparams; i++) {
                // TODO: Handle Null type hint
                preparedStatement.setObject(i + 1, params[i].toJavaObject());
            }
        }
    }

    protected void setRawParamedStmt(RawParamedSQL stmt) {
        rawParamedStatement = stmt;
    }

    protected void setParams(Obj[] params) {
        if (initialized) {
            if (!paramed) {
                throw new SQLScriptRuntimeException("Illegal state");
            }
            else if (namedParams != null) {
                throw new SQLScriptRuntimeException("Illegal state: Statement requires named parameters.");
            }
        }
        this.params = params;
        paramed = true;
    }

    protected void setNamedParams(Obj namedParams) {
        if (initialized) {
            if (!paramed) {
                throw new SQLScriptRuntimeException("Illegal state");
            }
            else if (params != null) {
                throw new SQLScriptRuntimeException("Illegal state: Statement requires positional parameters.");
            }
        }
        Map<String, List<Integer>> knownParams = rawParamedStatement.getParameters();
        Map<String, Obj> result = new HashMap<String, Obj>();
        for (Map.Entry<Obj, Obj> entry : namedParams.getSlots().entrySet()) {
            Str param = ensureType(entry.getKey());
            String paramName = param.value;
            if (!knownParams.containsKey(paramName)) {
                throw new SQLScriptRuntimeException("Invalid named parameter: " + paramName);
            }
            result.put(paramName, entry.getValue());
        }
        this.namedParams = result;
        paramed = true;
    }

    protected void parseParams() {
        if (rawParamedStatement != null) {
            if (keepResources) {
                return;
            }
            else {
                throw new SQLScriptRuntimeException("Illegal state");
            }
        }

        RawParamedSQL paramedStmt;
        try {
            paramedStmt = ParserHelper.parseParamedSQLLiteral(rawStatement);
        } catch (RecognitionException e) {
            throw new SQLScriptRuntimeException("Failed to parse SQL statement: " +
                                                rawStatement.getStatement(), e);
        }
        setRawParamedStmt(paramedStmt);
    }

    protected void close() throws SQLException {
        if (keepResources) {
            return;
        }

        try {
            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } finally {
            reset();
        }
    }

    protected void reset() {
        statement = null;
        preparedStatement = null;
        rawParamedStatement = null;
        paramed = false;
        params = null;
        namedParams = null;
        keepResources = false;
        initialized = false;
    }

    protected Statement getStatement() {
        return statement != null ? statement : preparedStatement;
    }

    @Override
    public int getObjectID() {
        return OBJECT_ID;
    }

    public static void regiserInContext(Context ctx) {
        StmtProto.registerInContext(ctx);
        ctx.registerProto(OBJECT_ID, StmtProto.OBJECT_ID);
    }

    @Override
    public Object toJavaObject() {
        return statement != null ? statement : preparedStatement != null ? preparedStatement : null;
    }

    public static class StmtProto extends PlainObj {
        public static final int OBJECT_ID = ProtoRegistry.generateObjectID();

        protected static final NativeCall nativeDo = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                try {
                    boolean hasResult = thiz.execute();
                    if (hasResult) {
                        ResultSet rs = thiz.getStatement().getResultSet(); // NOTE: rs closed implicitly with statement
                        engine.getContext().notifyResultSet(rs);
                    }
                    else {
                        int updateCount = thiz.getStatement().getUpdateCount();
                        engine.getContext().notifyUpdateCount(updateCount);
                    }

                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Query failed: " + e.getMessage(), e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }
                return thiz;
            }
        };

        protected static final NativeCall nativeExec = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                try {
                    thiz.execute();
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Query failed: " + e.getMessage(), e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }
                return thiz;
            }
        };

        protected static final NativeCall nativeEach = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                Obj closure = args[0];
                Null _null = engine.getObjNull();
                try {
                    ResultSet rs = thiz.query();
                    ResSet resSet = new ResSet(rs);
                    while (rs.next()) {
                        try {
                            engine.invokeInLoop(closure, _null, resSet);
                        } catch (LoopContinueException e) {
                            continue;
                        } catch (LoopBreakException e) {
                            break;
                        }
                    }
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Query failed: " + e.getMessage(), e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }

                return null;
            }
        };

        protected static final NativeCall nativeEachKey = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                Obj closure = args[0];
                Obj _null = engine.getObjNull();

                try {
                    ResultSet rs = thiz.retrieveKeys();
                    ResSet resSet = new ResSet(rs);
                    while (rs.next()) {
                        try {
                            engine.invokeInLoop(closure, _null, resSet);
                        } catch (LoopContinueException e) {
                            continue;
                        } catch (LoopBreakException e) {
                            break;
                        }
                    }
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Query failed: " + e.getMessage(), e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }

                return null;
            }
        };

        protected static final NativeCall nativeKey = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);

                try {
                    ResultSet rs = thiz.retrieveKeys();
                    if (rs.next()) {
                        return NativeWrapper.wrap(engine.getContext(), rs.getObject(1));
                    }
                    else {
                        return engine.getObjNull();
                    }
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Query failed: " + e.getMessage(), e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }
            }
        };

        protected static final NativeCall nativeWith = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                thiz.setParams(args);
                return thiz;
            }
        };

        protected static final NativeCall nativeWithNamed = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                Obj params = args[0];

                thiz.parseParams();
                thiz.setNamedParams(params);

                return thiz;
            }
        };

        // TODO: How to handle update counts???
        protected static final NativeCall nativeBatch = new NativeBatchCall() {
            public Obj batchCall(SQLScriptEngine engine, Obj context, Obj closure, int batchSize)
                    throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);

                try {
                    thiz.initPrepared();
                    ParamBatch batch = new ParamBatch(thiz, batchSize);
                    engine.invoke(closure, engine.getObjNull(), batch);
                    batch.finish();
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Batch execution failed: " + e, e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }

                return thiz;
            }
        };

        protected static final NativeCall nativeBatchNamed = new NativeBatchCall() {
            public Obj batchCall(SQLScriptEngine engine, Obj context, Obj closure, int batchSize)
                    throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);

                try {
                    thiz.parseParams();
                    thiz.initPrepared();
                    NamedParamBatch batch = new NamedParamBatch(thiz, batchSize);
                    engine.invoke(closure, engine.getObjNull(), batch);
                    batch.finish();
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException("Batch execution failed " + e, e);
                } finally {
                    try {
                        thiz.close();
                    } catch (SQLException ignored) {
                    }
                }

                return thiz;
            }
        };

        protected static final NativeCall nativeWithPrepared = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                Obj closure = args[0];

                try {
                    thiz.enterManagedMode();
                    engine.invoke(closure, engine.getObjNull(), thiz);
                } finally {
                    try {
                        thiz.leaveManagedMode();
                    } catch (SQLException ignored) {
                    }
                }

                return thiz;
            }
        };

        protected static final NativeCall nativeGetQueryString = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                Stmt thiz = ensureType(context);
                return new Str(thiz.rawStatement.getStatement());
            }
        };

        public StmtProto() {
            slots.put(Str.SYM_do, nativeDo);
            slots.put(Str.SYM_exec, nativeExec);
            slots.put(Str.SYM_each, nativeEach);
            slots.put(Str.SYM_eachKey, nativeEachKey);
            slots.put(Str.SYM_key, nativeKey);
            slots.put(Str.SYM_with, nativeWith);
            slots.put(Str.SYM_withNamed, nativeWithNamed);
            slots.put(Str.SYM_batch, nativeBatch);
            slots.put(Str.SYM_batchNamed, nativeBatchNamed);
            slots.put(Str.SYM_withPrepared, nativeWithPrepared);
            slots.put(Str.SYM_getQueryString, nativeGetQueryString);
        }

        @Override
        public int getObjectID() {
            return OBJECT_ID;
        }

        public static void registerInContext(Context ctx) {
            Base.registerInContext(ctx);
            ctx.registerProto(OBJECT_ID, Base.OBJECT_ID);
            ctx.registerObject(new StmtProto());
        }
    }

    protected static class ParamBatch extends PlainObj {
        protected Stmt stmt;
        protected int batchSize;
        protected int currentBatchSize = 0;

        protected static NativeCall nativeAdd = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                ParamBatch thiz = ensureType(context);
                try {
                    thiz.stmt.addBatch(args);
                    if (++thiz.currentBatchSize % thiz.batchSize == 0) {
                        thiz.stmt.execBatch();
                        thiz.currentBatchSize = 0;
                    }
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException(e);
                }
                return thiz;
            }
        };

        protected static NativeCall nativeFinish = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                ParamBatch thiz = ensureType(context);
                try {
                    thiz.finish();
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException(e);
                }
                return thiz;
            }
        };

        public ParamBatch(Stmt stmt, int batchSize) {
            this.stmt = stmt;
            this.batchSize = batchSize;
            slots.put(Str.SYM_add, nativeAdd);
            slots.put(Str.SYM_finish, nativeFinish);
        }

        protected void finish() throws SQLException {
            if (currentBatchSize == 0) {
                return;
            }

            stmt.execBatch();
        }
    }

    protected static class NamedParamBatch extends ParamBatch {
        protected static NativeCall nativeAdd = new NativeCall() {
            public Obj call(SQLScriptEngine engine, Obj context, Obj... args) throws ClosureTerminatedException {
                ParamBatch thiz = ensureType(context);
                try {
                    thiz.stmt.addNamedBatch(args[0]);
                    if (++thiz.currentBatchSize % thiz.batchSize == 0) {
                        thiz.stmt.execBatch();
                        thiz.currentBatchSize = 0;
                    }
                } catch (SQLException e) {
                    throw new SQLScriptRuntimeException(e);
                }
                return thiz;
            }
        };

        public NamedParamBatch(Stmt stmt, int batchSize) {
            super(stmt, batchSize);
            slots.put(Str.SYM_add, nativeAdd);
        }
    }

}
