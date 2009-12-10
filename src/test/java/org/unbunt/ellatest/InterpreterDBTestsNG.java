package org.unbunt.ellatest;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import static org.unbunt.ella.Ella.eval;
import org.unbunt.ella.exception.EllaException;
import org.unbunt.ella.exception.EllaIOException;
import org.unbunt.ella.exception.EllaParseException;
import static org.unbunt.ellatest.TestUtils.ensureType;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Test(groups = { "interpreter-db" }, dependsOnGroups = "interpreter")
public class InterpreterDBTestsNG extends AbstractTest {
    public static final String PROPS_PATH = "src/main/config/";

    public static final String PROPS_MYSQL = "mysql.properties";
    public static final String PROPS_PGSQL = "pg.properties";
    public static final String PROPS_ORACLE = "oracle.properties";

    @Test
    public void connectMysql() throws EllaIOException, EllaParseException, SQLException, EllaException {
        Object result = eval(String.format(".ConnMgr.createFromProps('%s', 'mysql');", propsMysql()));
        Connection conn = ensureType(Connection.class, result);
        conn.close();
    }

    @Test(dependsOnMethods = "connectMysql")
    public void connActivate() throws EllaIOException, EllaParseException, EllaException {
        // TODO: Close connections
        eval("{\n" +
                String.format("var conn1 := ConnMgr.createFromProps('%s', 'mysql');\n", propsMysql()) +
                String.format("var conn2 := ConnMgr.createFromProps('%s', 'mysql');\n", propsMysql()) +
                ".conn2.do {=>\n" +
                "   if (ConnMgr.active !== conn2) {\n" +
                "       throw 'conn2 not active';\n" +
                "   }\n" +
                "};\n" +
                "if (ConnMgr.active !== conn1) {\n" +
                "   throw 'conn1 not active';" +
                "}\n" +
                "}\n"
        );
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Test(dependsOnMethods = "connectMysql")
    public void connAutoClose() throws EllaParseException, EllaIOException, EllaException, SQLException {
        Object result = eval(file("conn-auto-close"), propsMysql());
        assertNotNull(result);
        assertTrue(result instanceof List, "Expected list of connections - got " + result.getClass());
        List<Object> connections = (List<Object>) result;
        assertFalse(connections.isEmpty(), "List of connections is empty - at least one connection expected");
        int nopen = 0;
        for (Object elem : connections) {
            assertNotNull(elem);
            assertTrue(elem instanceof Connection);
            Connection connection = (Connection) elem;
            if (!connection.isClosed()) {
                nopen++;
            }
        }
        assertEquals(nopen, 0, "Connection auto-close broken: " +
                               nopen + " out of " + connections.size() + " " +
                               "connections still open");
    }

    @Test(dependsOnMethods = "connActivate")
    public void sqlLiteralVariableSubstitution()
            throws EllaIOException, EllaParseException, EllaException {
        eval(file("sql-literal-variable-substitution"), propsMysql(), "mysql");
    }

    @Test(dependsOnMethods = "connectMysql")
    public void tx() throws EllaIOException, EllaParseException, EllaException {
        eval(file("tx"), propsMysql());
    }

    @Test(dependsOnMethods = "connectMysql")
    public void mysqlStmtKey() throws EllaIOException, EllaException, EllaParseException {
        eval(file("mysql-stmt-key"), propsMysql());
    }

    @Test(dependsOnMethods = "connectMysql")
    public void mysqlResSetUpdate() throws EllaIOException, EllaException, EllaParseException {
        eval(file("mysql-resset-update"), propsMysql());
    }

    @Test(dependsOnMethods = "connectMysql")
    public void mysqlResSetInsert() throws EllaIOException, EllaException, EllaParseException {
        eval(file("mysql-resset-insert"), propsMysql());
    }

    @Test
    public void connectPostgresql() throws EllaParseException, EllaIOException, EllaException, SQLException {
        Object result = eval(".ConnMgr.createFromProps(ARGV[0]);", propsPG());
        Connection conn = ensureType(Connection.class, result);
        conn.close();
    }

    @Test(dependsOnMethods = "connectPostgresql")
    public void postgresqlStringSingleQuoted() throws EllaParseException, EllaIOException, EllaException {
        Object result = eval(".ConnMgr.createFromProps(ARGV[0]);" +
                             ".(sql select 'foobar' as foo).first().foo;", propsPG());
        assertEquals(result, "foobar");
    }

    @Test(dependsOnMethods = "connectPostgresql")
    public void postgresqlStringDollarQuoted() throws EllaParseException, EllaIOException, EllaException {
        Object result = eval(".ConnMgr.createFromProps(ARGV[0]); " +
                             "\\set quotes=pg; " +
                             ".(sql select $$foo)bar$$ as foo).first().foo;",
                             propsPG());
        assertEquals(result, "foo)bar");
    }

    @Test(dependsOnMethods = "connectPostgresql")
    public void postgresqlStringDollarQuotedTag() throws EllaParseException, EllaIOException, EllaException {
        Object result = eval(".ConnMgr.createFromProps(ARGV[0]); " +
                             "\\set quotes=pg; " +
                             ".(sql select $tag$foo)bar$tag$ as foo).first().foo;",
                             propsPG());
        assertEquals(result, "foo)bar");
    }

    @Test(dependsOnMethods = "connectPostgresql")
    public void postgresqlStringDollarQuotedVarSubst() throws EllaParseException, EllaIOException, EllaException {
        Object result = eval(".ConnMgr.createFromProps(ARGV[0]); " +
                             "\\set quotes=pg; " +
                             "var foo := 'foobar'; " +
                             ".(sql select $tag$foo@{foo})bar$tag$ as foo).first().foo;",
                             propsPG());
        assertEquals(result, "foofoobar)bar");
    }

    @Test
    public void connectOracle() throws EllaIOException, EllaParseException, SQLException, EllaException {
        Object result = eval(
                String.format(".ConnMgr.createFromProps('%s', 'oracle');", propsOracle())
        );
        Connection conn = ensureType(Connection.class, result);
        conn.close();
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleInsertSelectSimple() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-insert-select-simple"), propsOracle());
    }

    @Test(dependsOnMethods = "oracleInsertSelectSimple")
    public void oracleStmtFirst() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-stmt-first"), propsOracle());
    }

    @Test(dependsOnMethods = "oracleStmtFirst")
    public void oracleQQuotedStringAlphaDelim() throws EllaParseException, EllaIOException, EllaException {
        String code = ".ConnMgr.createFromProps(ARGV[0]); " +
                      "\\set quotes=ora; " +
                      ".(sql select q'Xfoo')barX' as str from dual).first().STR;";
        Object result = eval(code, propsOracle());
        assertEquals(result, "foo')bar");
    }

    @Test(dependsOnMethods = "oracleStmtFirst")
    public void oracleQQuotedStringSquotDelim() throws EllaParseException, EllaIOException, EllaException {
        String code = ".ConnMgr.createFromProps(ARGV[0]); " +
                      "\\set quotes=ora; " +
                      ".(sql select q''foo')bar'' as str from dual).first().STR;";
        Object result = eval(code, propsOracle());
        assertEquals(result, "foo')bar");
    }

    @Test(dependsOnMethods = "oracleStmtFirst")
    public void oracleQQuotedStringCurlyDelim() throws EllaParseException, EllaIOException, EllaException {
        String code = ".ConnMgr.createFromProps(ARGV[0]); " +
                      "\\set quotes=ora; " +
                      ".(sql select q'{x'xx''zz}yy@'}' as str from dual).first().STR;";
        Object result = eval(code, propsOracle());
        assertEquals(result, "x'xx''zz}yy@'");
    }

    @Test(dependsOnMethods = "oracleQQuotedStringCurlyDelim")
    public void oracleQQuotedStringCurlyDelimVarSubst() throws EllaParseException, EllaIOException, EllaException {
        String code = ".ConnMgr.createFromProps(ARGV[0]); " +
                      "\\set quotes=ora; " +
                      "var foo := 'foobar'; " +
                      "var baz := 'qux';" +
                      ".(sql select q'{x@{foo}'xx''zz@{baz}}yy@'}' as str from dual).first().STR;";
        Object result = eval(code, propsOracle());
        assertEquals(result, "xfoobar'xx''zzqux}yy@'");
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleConnBatch() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-conn-batch"), propsOracle());
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleStmtBatch() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-stmt-batch"), propsOracle());
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleStmtBatchNamed() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-stmt-batch-named"), propsOracle());
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleConnWithPrepared() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-conn-with-prepared"), propsOracle());
    }

    @Test(dependsOnMethods = "connectOracle")
    public void oracleConnWithPreparedNamed() throws EllaIOException, EllaException, EllaParseException {
        eval(file("oracle-conn-with-prepared-named"), propsOracle());
    }

    protected static String propsMysql() {
        return props(PROPS_MYSQL);
    }

    protected static String propsPG() {
        return props(PROPS_PGSQL);
    }

    protected static String propsOracle() {
        return props(PROPS_ORACLE);
    }

    protected static String props(String file) {
        String path = PROPS_PATH + file;
        String pathLocal = path + ".local";
        File fileLocal = new File(pathLocal);
        return fileLocal.exists() ? pathLocal : path;
    }

}
