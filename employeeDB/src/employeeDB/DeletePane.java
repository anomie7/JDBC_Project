package employeeDB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class DeletePane extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel[] jl = new JLabel[2];
	JPanel[] jp = new JPanel[3];
	JTextField[] tf = new JTextField[2];
	JButton okb, rsb;
	
	String[] caption = {"��� :", "�̸� :"};
	
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
		okb = new JButton("�����������");
		okb.addActionListener(this);
		rsb = new JButton("�ٽþ���");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO edvo = null;
		
		if(ae_type.equals(okb.getText())){
			edvo = new EmployeeDAO();
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
				JOptionPane.showMessageDialog(this,"���������� �����Ǿ����ϴ�.");
			}else{
				JOptionPane.showMessageDialog(this, "�˻�����");
			}
		}else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			
			for(int i = 0; i <size; i++){
				tf[i].setText("");
			}
		}
	}
	
}


