package hotel_reserve_pck;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

static Connection con;
	
	public static Connection createDBConnection() {
		
		
	try {
		//load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//Get Connection
		String url = "jdbc:mysql://localhost:3306/hotel_db?useSSL=false";
		String username = "root";
		String password = "password";
		
		con = DriverManager.getConnection(url,username,password);
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}
		
		return con;
	}
}
