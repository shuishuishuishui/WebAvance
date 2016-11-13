package dblab.hello;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Query {
	final static Logger logger = Logger.getLogger(MySQLConnection.class);
	String sql;

	public Query() {
	};

	public void query(DbConnection dbconn, final String sql) {

		Statement stmt = null;
		try {

			Connection conn = dbconn.getConnection();

			logger.debug("Creating statement...");
			stmt = conn.createStatement();

			String[] series = sql.split(" ");
			String sql2 = sql.replace(" ", ",");
			System.out.println(series[0]);
			System.out.println(sql2);

			String serie = "SELECT";
			if (!series[0].equals(serie)) {

				int rows = stmt.executeUpdate(sql);
				System.out.println(rows + " rows impacted");

			} else if (series[0].equals(serie)) {

				// sql = "SELECT * FROM actor ;";
				this.sql = sql;
				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData mtdt = rs.getMetaData();

				// Extract data from result set
				int nbCols = mtdt.getColumnCount();

				logger.debug(" NbCols " + nbCols);

				StringBuffer title = new StringBuffer();
				StringBuffer type = new StringBuffer();
				// java.text.SimpleDateFormat sdf = new
				// java.text.SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

				for (int i = 1; i < nbCols + 1; i++) {
					// String title = rs.getMetaData().getColumnName(i);
					title.append(mtdt.getColumnName(i)).append("\t |");
					type.append(mtdt.getColumnTypeName(i)).append("\t |").toString();
				}
				logger.info(title);
				logger.info(type);

				while (rs.next()) {
					StringBuffer lineBuffer = new StringBuffer();
					// StringBuffer title = new StringBuffer();

					for (int i = 1; i < nbCols + 1; i++) {

						lineBuffer.append(rs.getString(i)).append("\t |");
						// lineBuffer.append(sdf.format(rs.getTimestamp(i)).toString()).append("\t
						// |");
						// lineBuffer.append(rs.getMetaData().getColumnName(i)).append("\t
						// |");
						// title =

					}

					logger.info(lineBuffer.toString());

					// String last = rs.getString("last_name");
					//// print out sequence and query result
					// logger.info("lastname ["+rs.getRow()+"]: "+last);
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
				// try{
				// if(conn!=null)
				// conn.close();
				// }catch(SQLException se){
				// se.printStackTrace();
				// }//end finally try
		}
	}
}
