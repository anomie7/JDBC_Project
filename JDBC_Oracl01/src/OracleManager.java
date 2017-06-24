import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleManager {
	static String driver =  "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	static String userName = "scott";
	static String userPwd = "tiger";
	
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String ename, job, hiredate;
	private int eno, manager, salary, commission, dno;
	
	public OracleManager(){
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, userPwd);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public OracleManager(int eno){
		this();
		
		this.eno = eno;
	}
	
	public OracleManager(int eno, String ename,String job,int manager, String hiredate, int salary,int commission,int dno){
		this(eno);
		this.ename = ename;
		this.job = job;
		this.manager = manager;
		this.hiredate = hiredate;
		this.salary = salary;
		this.commission = commission;
		this.dno = dno;
	}
	
	void select(String sql){
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("사번 \t 이름 \t 직책 \t 상관 \t 입사일 \t 급여 \t 상여급 \t 부서번호 \t");
			System.out.println("--------------------------------------------------");
			
			while(rs.next()){
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(5) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getInt(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.print(rs.getInt(7) + "\t");
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
			
			pstmt.setInt(1, eno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, manager);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, salary);
			pstmt.setInt(7, commission);
			pstmt.setInt(8, dno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(ename + "이(가) 추가되었습니다.");
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
			pstmt.setInt(1, eno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(eno + "이 삭제되었습니다.");
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
			
			pstmt.setInt(1, eno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, manager);
			pstmt.setString(5, hiredate);
			pstmt.setInt(6, salary);
			pstmt.setInt(7, commission);
			pstmt.setInt(8, dno);
			
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(ename + "님의 정보가 수정되었습니다.");
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
