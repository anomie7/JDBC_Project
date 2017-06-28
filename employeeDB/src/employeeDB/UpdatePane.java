package employeeDB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class UpdatePane extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] jp = new JPanel[6];
	private JLabel[] jl = new JLabel[5];
	private JTextField[] tf = new JTextField[5];
	private JButton okb, rsb, slb;
	String[] caption = {"사번 :", "이름 :", "직책 : ", "부서 : ", "메일: "};
	
	
	public UpdatePane(){
		setLayout(new GridLayout(6,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		for(int i = 0; i < size; i++){
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			if(i >= 2){
				tf[i].setEditable(false);
			}
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		
		jp[size] = new JPanel();
		slb = new JButton("사원조회");
		slb.addActionListener(this);
		okb = new JButton("수정하기");
		okb.addActionListener(this);
		okb.setEnabled(false);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		
		jp[size].add(slb);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO edvo = null;
	
		if(ae_type.equals(slb.getText())){
			edvo = new EmployeeDAO();
			String sno = tf[0].getText().trim();
			String sname = tf[1].getText().trim();
			okb.setEnabled(true);
			
			try{
				
			if(!sno.equals("") && !sname.equals("")){
				int no = Integer.parseInt(sno);
				evo = edvo.getEmployeeCheck(no, sname);
			}else if(!sno.equals("") && sname.equals("")){
				int no = Integer.parseInt(sno);
				evo = edvo.getEmployeeNO(no);
			}else if(sno.equals("") && !sname.equals("")){
				evo = edvo.getEmployeeName(sname);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
			
		if(evo != null){
			tf[0].setText(evo.getNo()+"");
			tf[0].setEditable(false);
			tf[1].setText(evo.getName());
			tf[1].setEditable(false);
			tf[2].setText(evo.getJobGrade());
			tf[2].setEditable(true);
			tf[3].setText(evo.getDepartment()+"");
			tf[3].setEditable(true);
			tf[4].setText(evo.getEmail());
			tf[4].setEditable(true);
			
		}else{
			JOptionPane.showMessageDialog(this, "검색실패");
		}
				
			
		}else if(ae_type.equals(okb.getText())){
			try{
				edvo = new EmployeeDAO();
				int sno = Integer.parseInt( tf[0].getText().trim());
				String sname = tf[1].getText().trim();
				String sjobGrade = tf[2].getText().trim();
				int ndepartment = Integer.parseInt(tf[3].getText());
				String semail = tf[4].getText().trim();
				edvo.updateEmployee(sno, sname, sjobGrade, ndepartment, semail);
				JOptionPane.showMessageDialog(this, "수정성공!");
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			
			for(int i = 0; i <size; i++){
				tf[i].setText("");
				tf[i].setEditable(false);
				if(1 == 0 || i ==1){
					tf[0].setEditable(true);
					tf[1].setEditable(true);
			}
				
				okb.setEnabled(false);
		}
	}
		
	}
}
