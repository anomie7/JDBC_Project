package employeeDB;

import java.awt.*;

import javax.swing.*;


public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tp;
	private AddPane ap;
	private FindPane fp;
	private TotalPane tpa;
	
	public MainFrame(){
		tp = new JTabbedPane();
		ap = new AddPane();
		fp = new FindPane();
		
		tp.addTab("사원정보입력", ap);
		tp.addTab("사원정보조회", fp);
		tp.addTab("사원전체보기", tpa);
		
		getContentPane().add(tp);
		setTitle("사원관리(JDBC 버전)");
		
		Dimension d = new Dimension(400, 350);
		setSize(d);
//		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args){
		new MainFrame();
	}

}
