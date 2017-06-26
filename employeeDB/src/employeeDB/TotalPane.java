package employeeDB;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TotalPane extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TotalPane(){
		JTable table = new JTable(new EmployModel());
		add(new JScrollPane(table));
	}
}
