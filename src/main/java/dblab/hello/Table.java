package dblab.hello;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Table implements Db {

	String strTableName;
	String strCreateTable = " CREATE TABLE";

	public Table() {

	}

	public void execQuery(String strTableName) {
		// TODO Auto-generated method stub
		this.strTableName = strTableName;
	}

	public String toSQL() {
		// TODO Auto-generated method stub
		return strCreateTable + ":" + strTableName;
	}

	public Table Factory(DbConnection dbconn) throws SQLException {
		Table table = new Table();
		Connection conn = dbconn.getConnection();
		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet ColumnList = dmd.getColumns(null, null, "%", null);

		while (ColumnList.next()) {
			System.out.println("==Column==>" + ColumnList.getString("COLUMN_NAME"));
		}
		return table;
	}

	public void execQuery() {
		// TODO Auto-generated method stub

	}
}