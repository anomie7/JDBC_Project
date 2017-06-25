package oracle01;

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
	
	public OracleManager(int eno, String job, int manager, String hiredate, int salary, int commission, int dno) {
		this(eno);
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
			
			System.out.printf("%4s %8s %8s %4s %8s %4s %4s %4s \n", "���    ", "�̸�        ", "��å        ", "���    ", "�Ի���        ", "�޿�    ", "�󿩱�    ", "�μ���ȣ    ");
			System.out.println("--------------------------------------------------");
			
			while(rs.next()){
				System.out.printf("%4d\t", rs.getInt(1));
				System.out.printf("%8s\t", rs.getString(2));
				System.out.printf("%8s\t", rs.getString(3));
				System.out.printf("%4d\t", rs.getInt(4));
				System.out.printf("%8s\t", rs.getString(5));
				System.out.printf("%4d\t", rs.getInt(6));
				System.out.printf("%4d\t", rs.getInt(7));
				System.out.printf("%4d \n", rs.getInt(8));
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
				System.out.println(ename + "��(��) �߰��Ǿ����ϴ�.");
			}else{
				System.out.println("������ �߰��� �����Ͽ����ϴ�.");
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
				System.out.println(eno + "�� �����Ǿ����ϴ�.");
			}else{
				System.out.println("������ ������ �����Ͽ����ϴ�.");
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
			
			
			pstmt.setString(1, job);
			pstmt.setInt(2, manager);
			pstmt.setString(3, hiredate);
			pstmt.setInt(4, salary);
			pstmt.setInt(5, commission);
			pstmt.setInt(6, dno);
			pstmt.setInt(7, eno);
			int rowCount = pstmt.executeUpdate();
			
			if(rowCount == 1){
				System.out.println(eno + "������ ������ �����Ǿ����ϴ�.");
			}else {
				System.out.println("���� ����");
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
