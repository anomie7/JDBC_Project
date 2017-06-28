package employeeDB;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import employeeDB2.EmployeeDAO2;

public class EmployModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Object[][] data;
	Object[] columnName;
	
	EmployeeDAO2 emDao = new EmployeeDAO2();
	EmployeeVO emVo;
	ArrayList<String> title;
	ArrayList<EmployeeVO> list;
	
	public EmployModel(){
		title = emDao.getColumnName();
		columnName = title.toArray();
		int columnCount = title.size();
		list = emDao.getEmployeeTotal();
		int rowCount = list.size();
		data = new Object[rowCount][columnCount];
		for(int index = 0; index< rowCount; index++){
			emVo = list.get(index);
			data[index][0] = emVo.getNo();
			data[index][1] = emVo.getName();
			data[index][2] = emVo.getJobGrade();
			data[index][3] = emVo.getDepartment();
			data[index][4] = emVo.getEmail();
		}
	}
	@Override
	public int getColumnCount(){
		if(columnName == null){
			return 0;
		}else{
			return columnName.length;
		}
	}
	@Override
	public int getRowCount(){
		if(data == null){
			return 0;
		}else{
			return data.length;
		}
	}
	
	public Object getValueAt(int rowIndex, int columnIndex){
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public String getColumnName(int column){
		return (String)columnName[column];
	}
}
