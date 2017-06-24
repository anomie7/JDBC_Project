import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest01 {
	public static void main(String[] args){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("데이터베이스 연결 성공!");
		}catch(Exception e){
			System.out.println("데이터 베이스 연결 실패!");
		} finally{
			try{
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

}
