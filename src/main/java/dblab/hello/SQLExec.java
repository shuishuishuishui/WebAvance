package dblab.hello;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLExec {

	public static void main (String[] args){
	
	//  to get data from arguments in command line:
	//	Scanner scanner = new Scanner(System.in);
	//	System.out.println("Enter your name:");
	//	String username = scanner.next();
		
	//	System.out.println(String.format("%s,Hello", username));
		
		//what asked are different , asked to be put as input in the first place
		
		String arg_url= args[0];
		String arg_driverName= args[1];
		String arg_userName= args[2];
		String arg_password= args[3];
		String arg_query= args[4];
		
		Connection conn = null;
		Statement stmt =null;
		
		
		try {
		//	String url = "jdbc:mysql://localhost:8889/sakila";
		//	String user = "root";
		//	String password = "root";
		//	Class.forName("com.mysql.jdbc.Driver");  
			
			String url = arg_url;
			String user = arg_userName;
			String password = arg_password;
			Class.forName(arg_driverName);  
			
			conn = DriverManager.getConnection(url,user,password);
			if(conn!=null){
				System.out.println("Connected to the database");
			}
			
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			
			
		//	sql = "SELECT last_name FROM actor ;";
			sql = arg_query;
			String[] srg = sql.split(" ");
			String msg = srg[1];
			
			ResultSet rs = stmt.executeQuery(sql);
			
			
			//Extract data from result set
			
				//print out the header
			System.out.println(msg);
			System.out.println("-------------------------------");
			
			while(rs.next()){
				String last = rs.getString(msg);
				
				// print out sequence and query result
				System.out.println("["+rs.getRow()+"]: "+last);
			}
		
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch(SQLException ex) {
			System.out.println("An error occurred.Maybe user/password is invalid");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		System.out.println("Goodbye!");
	
	}//end main
}
