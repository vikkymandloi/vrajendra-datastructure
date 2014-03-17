package JDBCSimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ConnectionPool {
	String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "system";
	String password = "manager";
	int No_Of_Conn = 10;
	Map<Integer, Connection> con = new HashMap<Integer, Connection>();
	
	public ConnectionPool()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for(int i=0;i<No_Of_Conn;i++){	
				con.put(i, DriverManager.getConnection(connectionURL,userName, password));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ShowSelect(Connection con1){
		try {
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery("select * from temp1 where id='285246'");
			while (rs.next())
			    System.out.println("ID = " + rs.getString("id") + ", Name = " + rs.getString("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			ConnectionPool c1 = new ConnectionPool();
			Set s1 = c1.con.entrySet();
			Iterator it1 = s1.iterator();
			while(it1.hasNext()){
				Map.Entry ent1 = (Entry) it1.next();
				if(ent1.getKey().equals(4)){
					((Connection)ent1.getValue()).close();
				}
				System.out.println(ent1.getKey()+" == "+ent1.getValue());
				c1.ShowSelect((Connection)ent1.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
