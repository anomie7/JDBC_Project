package employeeDB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class UpdatePane extends JPanel implements ActionListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] jp = new JPanel[6];
	private JLabel[] jl = new JLabel[5];
	private JTextField[] tf = new JTextField[4];
	private JComboBox<String> combo;
	private JButton okb, rsb;
	private int department = 10;
	String[] caption = {"��� :", "�̸� :", "��å : ", "���� : ", "�μ�: "};
	
	
	public UpdatePane(){
		setLayout(new GridLayout(6,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		
		int i;
		for(i = 0; i < size-1; i++){
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		
		jp[i] = new JPanel();
		jl[i] = new JLabel(caption[i]);
		jp[i].add(jl[i]);
		add(jp[i]);
		
		combo= new JComboBox<String>();
		combo.addItem("�μ���ȣ�� �����ϼ���.");
		for(int c = 1; c <=5; c++){
			combo.addItem(Integer.toString(c*10));
		}
		jp[i].add(combo);
		combo.addItemListener(this);
		
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
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			department = Integer.parseInt(e.getItem().toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO edvo = null;
		if(ae_type.equals(okb.getText())){
			try{
				edvo = new EmployeeDAO();
				String sno = tf[0].getText().trim();
				String sname = tf[1].getText().trim();
				String sjobGrade = tf[2].getText().trim();
				String semail = tf[3].getText().trim();
				
				if(!sno.equals("") && !sname.equals("")){
					int no = Integer.parseInt(sno);
					EmployeeVO tmp = new EmployeeVO(no, sname, sjobGrade, department, semail);
					evo = edvo.getUpdateCheck(tmp);
				}else if(!sno.equals("") && sname.equals("")){
					int no = Integer.parseInt(sno);
					EmployeeVO tmp = new EmployeeVO(no, "", sjobGrade, department, semail);
					evo = edvo.getUpdateNo(tmp);
				}else if(sno.equals("") && !sname.equals("")){
					EmployeeVO tmp = new EmployeeVO(0, sname, sjobGrade, department, semail);
					evo = edvo.getUpdateName(tmp);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			if(evo != null){
				tf[0].setText(evo.getNo()+"");
				tf[1].setText(evo.getName());
				tf[2].setText(evo.getJobGrade());
				tf[3].setText(evo.getEmail());
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
