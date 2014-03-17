package JDBCSimple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ConnectionPolComplicated {
	String connectionURL = "jdbc:oracle:thin:@localhost:1521:XE";
	String userName = "system";
	String password = "manager";
	static int No_Of_Conn = 10;
	Map<Connection, Boolean> con = new HashMap<Connection,Boolean>();
	Set s1 = null;
	Iterator it1 = null;

	public ConnectionPolComplicated()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for(int i=0;i<No_Of_Conn;i++){	
				con.put(DriverManager.getConnection(connectionURL, userName, password),false);
			}
			s1 = con.entrySet();
			it1 = s1.iterator();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	/*public void showAllConnection(){
		while(it1.hasNext()){
			Map.Entry ent1 = (Entry) it1.next();
			System.out.println(ent1.getKey()+" == "+ent1.getValue());
		}
	}*/

	public Connection SeekConnection(){
		while(it1.hasNext()){
			Map.Entry ent1 = (Entry) it1.next();
			if(ent1.getValue().equals(false))
			{	
				ent1.setValue(true);
				return ((Connection)ent1.getKey());
			}
		}
		return null;
	}
	
	public void CloseConnection(Connection con1){
		try {
			while(it1.hasNext()){
				Map.Entry ent1 = (Entry) it1.next();
				if(ent1.getKey().equals(con1))
				{	
					ent1.setValue(false);
					((Connection)ent1.getKey()).close();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void UseConnection(Connection con2){
		try {
			Statement stmt = con2.createStatement();
			ResultSet rs = stmt.executeQuery("select * from temp1 where id='285246'");
			while (rs.next())
			    System.out.println("ID = " + rs.getString("id") + ", Name = " + rs.getString("name"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			ConnectionPolComplicated c1 = new ConnectionPolComplicated();
			//c1.showAllConnection();
			
			System.out.println("----------------------------------------------------");
			for(int i=0;i<No_Of_Conn;i++){
				Connection con3 = c1.SeekConnection();
				if(con3.equals(null)){
					System.out.println("No More Connections Left");
					break;
				}
				c1.UseConnection(con3);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
