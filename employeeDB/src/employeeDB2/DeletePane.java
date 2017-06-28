package employeeDB2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import employeeDB2.EmployeeDAO2;

public class DeletePane extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel[] jl = new JLabel[2];
	JPanel[] jp = new JPanel[3];
	JTextField[] tf = new JTextField[2];
	JButton okb, rsb;
	
	String[] caption = {"사번 :", "이름 :"};
	
	public DeletePane(){
		
		setLayout(new GridLayout(3, 1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		for(int i = 0; i < size; i++){
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		jp[size] = new JPanel();
		okb = new JButton("사원정보삭제");
		okb.addActionListener(this);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO2 edvo = null;
		
		if(ae_type.equals(okb.getText())){
			edvo = new EmployeeDAO2();
			String sno = tf[0].getText().trim();
			String sname = tf[1].getText().trim();
			try{
				if(!sno.equals("") && !sname.equals("")){
					int no = Integer.parseInt(sno);
					EmployeeVO tmp = new EmployeeVO(no, sname, "", 0, "");
					evo = edvo.getDeleteCheck(tmp);
				}else if(!sno.equals("") && sname.equals("")){
					int no = Integer.parseInt(sno);
					EmployeeVO tmp = new EmployeeVO(no, "", "", 0, "");
					evo = edvo.getDeleteNo(tmp);
				}else if(sno.equals("") && !sname.equals("")){
					EmployeeVO tmp = new EmployeeVO(0, sname, "", 0, "");
					evo = edvo.getDeleteName(tmp);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}if(evo != null){
				JOptionPane.showMessageDialog(this,"성공적으로 삭제되었습니다.");
			}else{
				JOptionPane.showMessageDialog(this, "검색실패");
			}
		}else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			
			for(int i = 0; i <size; i++){
				tf[i].setText("");
			}
		}
	}
	
}


