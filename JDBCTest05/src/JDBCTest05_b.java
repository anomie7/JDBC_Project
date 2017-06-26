import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCTest05_b {
	final static String sql = "update employee set jobGrade = ?, department = ?, email = ? where name = ?";
	
	public static void main(String[] args){
		String drive = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sjobGrade, semail, sname, stemp;
		int ndepartment;
		
		
		try{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("�˻� : �̸� �Է�>>");
			sname = sc.nextLine();
			
			System.out.println("���� : ��å �Է�>>> ");
			sjobGrade = sc.nextLine();
			
			System.out.print("���� : �μ�>>");
			stemp = sc.nextLine();
			ndepartment = Integer.parseInt(stemp);
			
			System.out.print("���� : �̸���>");
			semail = sc.nextLine();
			
			sc.close();
			
			Class.forName(drive);
			con = DriverManager.getConnection(url, "root", "1234");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sjobGrade);
			pstmt.setInt(2, ndepartment);
			pstmt.setString(3, semail);
			pstmt.setString(4, sname);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(sname + "���� ������ �����Ǿ����ϴ�.");
			}else{
				System.out.println("������Ʈ�� �����Ͽ����ϴ�.");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
