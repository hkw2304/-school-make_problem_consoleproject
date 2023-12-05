package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFac {
	public Connection getConnection() {
		Connection con = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
 		String user = "hr";
 		String password = "hr";
		try {
			Class.forName(driver);
			System.out.println("dirver 연동 성공");
			con =DriverManager.getConnection(url, user, password);
			System.out.println("DB 연동 성동");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
}
