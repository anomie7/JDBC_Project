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

import employeeDB2.EmployeeDAO2;

public class AddPane extends JPanel implements ActionListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel[] jp = new JPanel[5];
	private JLabel[] jl = new JLabel[4];
	private JComboBox<String> combo;
	private JTextField[] tf = new JTextField[3];
	private JButton okb, rsb;
	private int department = 10;
	
	String[] caption = {"이름 :", "직 책 :", "메 일 :", "부 서 :"};
	
	public AddPane(){
		setLayout(new GridLayout(5,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		
		int i;
		for(i = 0; i<size -1; i++){
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
		
		combo = new JComboBox<String>();
		combo.addItem("부서번호를 선택하세요.");
		for(int c = 1; c<=5; c++){
			combo.addItem(Integer.toString(c*10));
		}
		jp[i].add(combo);
		combo.addItemListener(this);
		
		jp[size] = new JPanel();
		okb = new JButton("저장하기");
		okb.addActionListener(this);
		rsb = new JButton("다시쓰기");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
		String ae_type = ae.getActionCommand();
		EmployeeVO evo = null;
		EmployeeDAO2 edvo = null;
		if(ae_type.equals(okb.getText())){
			try{
				evo = new EmployeeVO(0, tf[0].getText(), tf[1].getText()
									, department, tf[2].getText());
				
				edvo = new EmployeeDAO2();
				edvo.getEmployeeRegiste(evo);
			}catch(Exception e){
				System.out.println(e);
			}
		}
			if(edvo != null){
				JOptionPane.showMessageDialog(this, tf[0].getText() + "님이 성공적으로 추가됨");
			}else if(ae_type.equals(rsb.getText())){
				int size = caption.length;
				
				for(int i = 0; i< size-1;i++){
					tf[i].setText("");
				}				
			}
		}
	
	public void itemStateChanged(ItemEvent ie){
		if(ie.getStateChange() == ItemEvent.SELECTED){
			department = Integer.parseInt(ie.getItem().toString());
		}
	}
	
}
