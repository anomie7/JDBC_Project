import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCTest05 {
	final static String sql = "update employee set name = ?, jobGrade = ?, department = ?, email = ?" + "where no = ?";
	public static void main(String[] args) {
		String driver =  "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
	
		String sname, sjobGrade, stemp, semail;
		int sno, department;
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("��� ������ �����մϴ�.");
			System.out.print("��� �Է�>>>>");
			sno = Integer.parseInt(sc.nextLine());
			System.out.print("�̸� �Է� >>>");
			sname = sc.nextLine();
			System.out.print("��å �Է� >>");
			sjobGrade = sc.nextLine();
			System.out.print("�μ���ȣ �Է�(10, 20, 30..)>>");
			stemp = sc.nextLine();
			department = Integer.parseInt(stemp);
			System.out.print("�̸��� �Է�>>");
			semail = sc.nextLine();
			
			sc.close();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");

			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, sname);
			pstmt.setString(2, sjobGrade);
			pstmt.setInt(3, department);
			pstmt.setString(4, semail);
			pstmt.setInt(5, sno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(sno + "���� ������ �����Ǿ����ϴ�.");
			}else {
				System.out.println("���� ����");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			try{
				if(con != null){
					con.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}

}
