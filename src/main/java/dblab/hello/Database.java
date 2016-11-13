package dblab.hello;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Database implements Db {
	private String strCreateDatabase = "CREATE DATABASE";
	private String strDatabaseName;
	Connection conn = null;
	final static Logger logger = Logger.getLogger(Database.class);

	public Database() {

	}

	public void execQuery(String DatabaseName) {
		// TODO Auto-generated method stub
		this.strDatabaseName = DatabaseName;

	}

	public String toSQL() {
		// TODO Auto-generated method stub
		return strCreateDatabase + ":" + this.strDatabaseName;
	}

	public Database factory(DbConnection dbconn) throws SQLException {
		Database database = new Database();

		logger.debug("Starting Connection");
		Connection conn = dbconn.getConnection();

		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet tableList = dmd.getTables(null, null, "%", null);
		while (tableList.next()) {
			System.out.println("==Table==>" + tableList.getString("TABLE_NAME"));
		}
		// ResultSet columeList = dmd.getTables(null, null, "actor", null);
		// while (columeList.next()) {
		// System.out.println("==Country==>" +
		// columeList.getString("TABLE_NAME"));
		// }
		return database;
	}

	public void execQuery() {
		// TODO Auto-generated method stub

	}

}