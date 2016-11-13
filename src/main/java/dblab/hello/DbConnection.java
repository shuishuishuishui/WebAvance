package dblab.hello;

import java.io.IOException;

import org.apache.log4j.Logger;

public class DbConnection {
	String username;
	String password;
	String driver;
	String url;
	final static Logger logger = Logger.getLogger(DbConnection.class);

	public DbConnection(String url, String username, String password, String driver) throws IOException {
		this.username = username;
		this.password = password;
		this.driver = driver;
		this.url = url;
		logger.debug("Loading Driver");
		try {
			Class.forName(this.driver);

		} catch (ClassNotFoundException cnf) {
			System.out.println("Unable to load Driver:" + this.driver);
		}
	}

	public java.sql.Connection getConnection() throws java.sql.SQLException {
		return java.sql.DriverManager.getConnection(this.url, this.username, this.password);
	}
}
