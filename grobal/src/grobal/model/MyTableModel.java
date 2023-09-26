package grobal.model;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
	Object[][] data = new Object[1][5];

	String[] columns = {"内定者番号", "氏名", "国籍", "年齢", "性別"};
	
	@Override
	  public String getColumnName(int column) {
	    return columns[column];
	}
	  
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
}