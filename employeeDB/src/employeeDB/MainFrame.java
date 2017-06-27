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
		tpa = new TotalPane();
		
		tp.addTab("��������Է�", ap);
		tp.addTab("���������ȸ", fp);
		tp.addTab("�����ü����", tpa);
		
		getContentPane().add(tp);
		setTitle("�������(JDBC ����)");
		
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
