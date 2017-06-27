package employeeDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	
	public EmployeeVO getEmployeeRegiste(EmployeeVO evo) throws Exception{
		String dml = "insert into employee(name, jobGrade, department, email) values(?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt= null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			
			pstmt.setString(1, evo.getName());
			pstmt.setString(2, evo.getJobGrade());
			pstmt.setInt(3, evo.getDepartment());
			pstmt.setString(4, evo.getEmail());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	public EmployeeVO getEmployeeCheck(int no, String name) throws Exception{
		String dml = "select *from employee where no = ? and name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), 
										rs.getInt(4), rs.getString(5));
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(Exception se){
				
			}
		}
		
		return retval;
	}
	public EmployeeVO getEmployeeNO(int no) throws Exception{
		
		String dml = "select *from employee where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5));
			}
			
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException se){
				
			}
		}
		return retval;
		
	}
	
	public EmployeeVO getEmployeeName(String name) throws Exception{
		String dml = "select *from employee where name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5));
			}
			
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException se){
				
			}
		}
		return retval;
	}
	//사번과 이름으로 수정
	public EmployeeVO getUpdateCheck(EmployeeVO evo) throws Exception{
		String dml = "update employee set jobGrade = ?, department = ?, email = ?" + "where no = ? and name = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, evo.getJobGrade());
			pstmt.setInt(2, evo.getDepartment());
			pstmt.setString(3, evo.getEmail());
			pstmt.setInt(4, evo.getNo());
			pstmt.setString(5, evo.getName());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	//사번으로 수정
	public EmployeeVO getUpdateNo(EmployeeVO evo) throws Exception{
		String dml = "update employee set jobGrade = ?, department = ?, email = ? where no = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, evo.getJobGrade());
			pstmt.setInt(2, evo.getDepartment());
			pstmt.setString(3, evo.getEmail());
			pstmt.setInt(4, evo.getNo());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	//이름으로 수정
	public EmployeeVO getUpdateName(EmployeeVO evo) throws Exception{
		String dml = "update employee set jobGrade = ?, department = ?, email = ? " + "where name = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, evo.getJobGrade());
			pstmt.setInt(2, evo.getDepartment());
			pstmt.setString(3, evo.getEmail());
			pstmt.setString(4, evo.getName());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	//사번과 이름으로 삭제
	public EmployeeVO getDeleteCheck(EmployeeVO evo) throws Exception{
		String dml = "delete from employee where no = ? and name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, evo.getNo());
			pstmt.setString(2, evo.getName());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	//사번으로 삭제
	public EmployeeVO getDeleteNo(EmployeeVO evo) throws Exception{
		String dml = "delete from employee where no = ? ";
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, evo.getNo());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	//이름으로 삭제 
	public EmployeeVO getDeleteName(EmployeeVO evo) throws Exception{
		String dml = "delete from employee where  name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		EmployeeVO retval = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, evo.getName());
			
			int i = pstmt.executeUpdate();
			retval = new EmployeeVO();
			retval.setStatus(i + "");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
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
		return retval;
	}
	
	public ArrayList<EmployeeVO> getEmployeeTotal(){
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		String tml = "select *from employee";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO emVo = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				emVo = new EmployeeVO(rs.getInt(1), 
									  rs.getString(2), 
									  rs.getString(3), 
									  rs.getInt(4), 
									  rs.getString(5));
				list.add(emVo);
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException se){
				
			}
		}
		return list;
	}
	
	public ArrayList<String> getColumnName(){
		ArrayList<String> columnName = new ArrayList<String>();
		String sql = "select *from employee";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ResultSetMetaData rsmd = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			
			int cols = rsmd.getColumnCount();
			
			for(int i = 1; i <= cols; i++){
				columnName.add(rsmd.getColumnName(i));
			}
		}catch(SQLException se){
			System.out.println(se);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch(SQLException se){
				
			}
		}
		return columnName;
	}
	
}
