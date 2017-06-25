package oracle02;
import java.util.Scanner;

public class OracleTest02 extends OracleManager{

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		while(true){
			System.out.print("$ ");
			String command = stdIn.next();
			
			if(command.equals("list")){
				String sql = "select * from employee";
				new OracleTest02().select(sql);
			}else if(command.equals("insert")){
				String[] str = new String[4];
				System.out.println("사원 정보 입력하기");
				System.out.print("이름 입력 >>>");
				str[0] = stdIn.next();
				System.out.print("직책 입력 >>");
				str[1] = stdIn.next();
				System.out.print("부서번호 입력(10, 20, 30..)>>");
				str[2] = stdIn.next();
				System.out.print("이메일 입력>>");
				str[3] = stdIn.next();
				
				String sql = "insert into employee(no, name, jobGrade, department, email) values(sample_seq.nextval,?,?,?,?)";
				new OracleManager(str[0], str[1], str[2], str[3]).insert(sql);
			}else if(command.equals("delete")){
				String sql = "delete from employee where no=?";
				System.out.println("사원 정보 삭제 하기");
				System.out.print("사번 입력>");
				new OracleManager(stdIn.nextInt()).delete(sql);
			}else if(command.equals("update")){
				String[] str = new String[4];
				System.out.println("사원 정보 수정하기");
				System.out.print("이름 입력 >>>>>");
				str[0] = stdIn.next();
				System.out.print("직책 입력 >>>>");
				str[1] = stdIn.next();
				System.out.print("부서번호 입력(10, 20, 30..)>>>");
				str[2] = stdIn.next();
				System.out.print("이메일 입력>>");
				str[3] = stdIn.next();
				System.out.print("사번 입력>");
				String sql = "update employee set name = ?, jobGrade = ?, department = ?, email = ?" + "where no = ?";
				new OracleManager(str[0], str[1], str[2], str[3], stdIn.nextInt()).update(sql);
				
			}else if(command.equals("exit")){
				break;
			}
		}
		stdIn.close();
		
	}
}
