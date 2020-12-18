package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/tj?"
				+"serverTimezone=Asia/Seoul&characterEncoding=utf8";
		String user =  "root";
		String password = "mysql";

		return DriverManager.getConnection(url, user, password);
	}
}
