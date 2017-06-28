package employeeDB;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import employeeDB2.UpdatePane2;

public class MainFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTabbedPane tp;
	private AddPane ap;
	private FindPane fp;
	private UpdatePane up;
	private DeletePane dp;
	private TotalPane tpa;
	
	public MainFrame(){
		setTitle("사원관리(JDBC 버전)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tp = new JTabbedPane();
		ap = new AddPane();
		fp = new FindPane();
		up = new UpdatePane();
		dp = new DeletePane();
		tpa = new TotalPane();
		
		tp.addTab("사원정보입력", ap);
		tp.addTab("사원정보조회", fp);
		tp.addTab("사원정보수정", up);
		tp.addTab("사원정보삭제", dp);
		tp.addTab("사원전체보기", tpa);
		
		tp.setComponentAt(0, ap);
		tp.setComponentAt(1, fp);
		tp.setComponentAt(2, up);
		tp.setComponentAt(3, dp);
		tp.setComponentAt(4, tpa);
		
		tp.addChangeListener(new ChangeListener(){
			@Override 
			public void stateChanged(ChangeEvent e){
				JTabbedPane tab = (JTabbedPane) e.getSource();
				if(tab.getSelectedIndex() == 4){
					TotalPane new_tpa = new TotalPane();
					tp.setComponentAt(4, new_tpa);
				}
			}
		});
		
		getContentPane().add(tp);
		
		
		Dimension d = new Dimension(400, 350);
		setSize(d);
		
		pack(); //사이즈를 모아줌
		setSize(600, 600);
		setVisible(true);
	}
	public static void main(String[] args){
		new MainFrame();
	}

}
