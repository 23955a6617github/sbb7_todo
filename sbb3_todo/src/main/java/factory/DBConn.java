package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	static Connection conn;
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbb3_todo","root","sohan123");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
