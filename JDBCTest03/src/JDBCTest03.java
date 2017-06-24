import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCTest03 {
	final static String sql =
			"insert into employee(name, jobGrade, department, email) values(?,?,?,?)";
	public static void main(String[] args){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sname, sjobGrade, semail, stemp;
		int department = 0;
		
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("사원 정보 입력하기");
			System.out.print("이름 입력 >>>");
			sname = sc.nextLine();
			System.out.print("직책 입력 >>");
			sjobGrade = sc.nextLine();
			System.out.print("부서번호 입력(10, 20, 30..)>>");
			stemp = sc.nextLine();
			department = Integer.parseInt(stemp);
			System.out.print("이메일 입력>>");
			semail = sc.nextLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, sjobGrade);
			pstmt.setInt(3, department);
			pstmt.setString(4, semail);
			int rowCount = pstmt.executeUpdate();
			
			System.out.println(rowCount);
			if(rowCount == 1){
				System.out.println(sname + "이(가) 추가되었습니다.");
			}else{
				System.out.println("데이터 추가에 실패하였습니다.");
			}
			sc.close();
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

}
