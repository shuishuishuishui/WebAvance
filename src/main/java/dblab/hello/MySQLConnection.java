package dblab.hello;

import org.apache.log4j.Logger;

public class MySQLConnection {

	final static Logger logger = Logger.getLogger(MySQLConnection.class);
	public static final DbConnection dbconn = null;
	static String url = "jdbc:mysql://localhost:8889/sakila";
	static String user = "root";
	static String password = "root";
	static String driver = "com.mysql.jdbc.Driver";

	public static void main(String[] args) throws Exception {
		// String[] args,
		DbConnection dbconn = new DbConnection(args[1], args[2], args[3], args[4]);
		Query query = new Query();
		query.query(dbconn, args[0]);

		// Database db = new Database();
		// db.execQuery("sakila");
		// System.out.println(db.toSQL());
		// db.factory(dbconn);
		//
		// Table tb = new Table();
		// tb.execQuery("actor");
		// System.out.println(tb.toSQL());
		// tb.Factory(dbconn);
		//
		// Collume cl = new Collume();
		// cl.execQuery("actor_id");
		// System.out.println(cl.toSQL());
		// cl.Factory(dbconn);

		// System.out.println("Goodbye!");
		// logger.error("ERROR");
		// logger.warn("WARNING");
		// logger.info("INFO");
		// logger.debug("DEBUG");

	}
}// end MySQLConnection
