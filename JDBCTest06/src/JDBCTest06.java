import java.util.Scanner;

public class JDBCTest06 extends MysqlManager{

	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		
		while(true){
			System.out.print("$ ");
			String command = stdIn.next();
			
			if(command.equals("list")){
				String sql = "select * from employee";
				new JDBCTest06().select(sql);
			}else if(command.equals("insert")){
				String[] str = new String[4];
				System.out.println("��� ���� �Է��ϱ�");
				System.out.print("�̸� �Է� >>>");
				str[0] = stdIn.next();
				System.out.print("��å �Է� >>");
				str[1] = stdIn.next();
				System.out.print("�μ���ȣ �Է�(10, 20, 30..)>>");
				str[2] = stdIn.next();
				System.out.print("�̸��� �Է�>>");
				str[3] = stdIn.next();
				
				String sql = "insert into employee(name, jobGrade, department, email) values(?,?,?,?)";
				new MysqlManager(str[0], str[1], str[2], str[3]).insert(sql);
			}else if(command.equals("delete")){
				String sql = "delete from employee where no=?";
				System.out.println("��� ���� ���� �ϱ�");
				System.out.print("��� �Է�>");
				new MysqlManager(stdIn.nextInt()).delete(sql);
			}else if(command.equals("update")){
				String[] str = new String[4];
				System.out.println("��� ���� �����ϱ�");
				System.out.print("�̸� �Է� >>>>>");
				str[0] = stdIn.next();
				System.out.print("��å �Է� >>>>");
				str[1] = stdIn.next();
				System.out.print("�μ���ȣ �Է�(10, 20, 30..)>>>");
				str[2] = stdIn.next();
				System.out.print("�̸��� �Է�>>");
				str[3] = stdIn.next();
				System.out.print("��� �Է�>");
				String sql = "update employee set name = ?, jobGrade = ?, department = ?, email = ?" + "where no = ?";
				new MysqlManager(str[0], str[1], str[2], str[3], stdIn.nextInt()).update(sql);
				
			}else if(command.equals("exit")){
				break;
			}
		}
		stdIn.close();
		
	}
}
