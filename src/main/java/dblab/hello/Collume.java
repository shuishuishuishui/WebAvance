package dblab.hello;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Collume implements Db {

	String strColumnName;
	String strCreateColumn = " CREATE Column";

	public Collume() {

	}

	public void execQuery(String strColumnName) {
		// TODO Auto-generated method stub
		this.strColumnName = strColumnName;
	}

	public String toSQL() {
		// TODO Auto-generated method stub
		return strCreateColumn + ":" + strColumnName;
	}

	public Collume Factory(DbConnection dbconn) throws SQLException {
		Collume column = new Collume();
		Connection conn = dbconn.getConnection();
		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet AttributeList = dmd.getAttributes(null, null, null, null);

		while (AttributeList.next()) {
			System.out.println("==Attribute==>" + AttributeList.getString("ATTRIBUTE_NAME"));
		}
		return column;
	}

	public void execQuery() {
		// TODO Auto-generated method stub

	}
}