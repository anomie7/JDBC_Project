package employeeDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static final String driver = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql://localhost:3306/jdbc?useSSL = false";

	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "root", "1234");

		return con;

	}

}
