package oracle01;

import java.util.Scanner;

public class OracleTest01 extends OracleManager{

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		while(true){
			System.out.print("$ ");
			String command = stdIn.next();
			
			if(command.equals("list")){
				String sql = "select eno, ename, job, manager,to_char(hiredate,'yy/mm/dd'), salary, commission, dno from employee";
				new OracleTest01().select(sql);
			}else if(command.equals("insert")){
				System.out.println("사원 정보 입력하기");
				System.out.print("사번 입력: ");
				int i1 = stdIn.nextInt();
				
				System.out.print("이름 입력: ");
				String s1 = stdIn.next();
				
				System.out.print("직책 입력: ");
				String s2 = stdIn.next();
						
				System.out.print("상관 입력: ");
				int i2 = stdIn.nextInt();
				
				System.out.print("입사일 입력: ");
				String s3 = stdIn.next();
				
				System.out.print("급여 입력: ");
				int i3 = stdIn.nextInt();
						
				System.out.print("상여금 입력: ");
				int i4 = stdIn.nextInt();
				
				System.out.print("부서 입력: ");
				int i5 = stdIn.nextInt();
				
				
				String sql = "insert into employee(eno, ename, job, manager, hiredate, salary, commission, dno) values(?,?,?,?,?,?,?,?)";
				new OracleManager(i1, s1, s2, i2, s3, i3, i4, i5).insert(sql);
			}else if(command.equals("delete")){
				String sql = "delete from employee where eno=?";
				System.out.println("사원 정보 삭제 하기");
				System.out.print("사번 입력>");
				new OracleManager(stdIn.nextInt()).delete(sql);
			}else if(command.equals("update")){
				System.out.println("사원 정보 입력하기");
				System.out.print("사번 입력: ");
				int i1 = stdIn.nextInt();
				
				System.out.print("직책 입력: ");
				String s1 = stdIn.next();
						
				System.out.print("상관 입력: ");
				int i2 = stdIn.nextInt();
				
				System.out.print("입사일 입력: ");
				String s2 = stdIn.next();
				
				System.out.print("급여 입력: ");
				int i3 = stdIn.nextInt();
						
				System.out.print("상여금 입력: ");
				int i4 = stdIn.nextInt();
				
				System.out.print("부서 입력: ");
				int i5 = stdIn.nextInt();
				
				
				String sql = "update employee set job = ?, manager = ?, hiredate = to_date(?, 'YYYYMMDD'), salary = ?, commission = ?, dno = ?"
						+ "where eno = ?";
				new OracleManager(i1, s1, i2, s2, i3, i4, i5).update(sql);
				
			}else if(command.equals("exit")){
				break;
			}
		}
		stdIn.close();
		
	}
}
