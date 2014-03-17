package JDBCSimple;

import java.sql.*;

public class JDBCtemp {

	public static void main(String[] args) {
		
		String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
		 
		try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection (connectionURL,"system","manager");
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("Select * from QA_SNAP_POS_WS_SUMMARY where QA_SNAP_POS_WS_SUMMARY_ID=1234");
		 
		    while (rs.next())
		        System.out.println("ID = " + rs.getInt(1) + ", Name = " + rs.getString(2));
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
