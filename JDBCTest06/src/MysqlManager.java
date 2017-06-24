import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlManager {
	static String driver =  "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";
	static String userName = "root";
	static String userPwd = "1234";
	
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String sname, sjobGrade, semail;
	private int sno, department;
	
	public MysqlManager(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, userPwd);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public MysqlManager(int sno){
		this();
		
		this.sno = sno;
	}
	
	public MysqlManager(String sname, String sjobGrade, String stemp, String semail){
		this();
		
		this.sname = sname;
		this.sjobGrade = sjobGrade;
		department = Integer.parseInt(stemp);
		this.semail = semail;
	}
	
	public MysqlManager(String sname, String sjobGrade, String stemp, String semail, int sno){
		this();
		this.sname = sname;
		this.sjobGrade = sjobGrade;
		department = Integer.parseInt(stemp);
		this.semail = semail;
		this.sno = sno;
	}
	
	void select(String sql){
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("번호 \t 이름 \t 직책 \t 부서 \t 이메일");
			System.out.println("--------------------------------------------");
			
			while(rs.next()){
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getString(5) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	void insert(String sql){
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, sjobGrade);
			pstmt.setInt(3, department);
			pstmt.setString(4, semail);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(sname + "이(가) 추가되었습니다.");
			}else{
				System.out.println("데이터 추가에 실패하였습니다.");
			}
		} catch (Exception e) {
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

	void delete(String sql){
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(sno + "이 삭제되었습니다.");
			}else{
				System.out.println("데이터 삭제에 실패하였습니다.");
			}
		} catch (Exception e) {
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
	
	void update(String sql){
		try{
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, sname);
			pstmt.setString(2, sjobGrade);
			pstmt.setInt(3, department);
			pstmt.setString(4, semail);
			pstmt.setInt(5, sno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(sno + "님의 정보가 수정되었습니다.");
			}else {
				System.out.println("수정 실패");
			}
		}catch(Exception e){
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
