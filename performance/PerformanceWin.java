package performance;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import login.Employee;
import login.Goods;
import dbsystem.Query;

import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class PerformanceWin extends JFrame{
	private JTextField textField;
	private JTable table;
	
	public PerformanceWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("查询员工销售额");
		getContentPane().setLayout(null);
		
		TableModel tablemodel=new TableModel();
		tablemodel.changeData(0);
		JTable table = new JTable(tablemodel);
		table.setBounds(14, 229, 880, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setVisible(false);
		scrollPane.setSize(880, 358);
		scrollPane.setLocation(14, 256);
		getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(188, 170, 263, 50);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u663E\u793A\u5168\u90E8\u5458\u5DE5\u9500\u552E\u989D");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablemodel.changeData(0);
				table.setVisible(false);
				table.setModel(tablemodel);
				table.setVisible(true);
			}
		});
		btnNewButton.setBounds(81, 34, 286, 56);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				tablemodel.changeData(0);
				table.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(484, 34, 339, 56);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")==false){
					tablemodel.changeData(Integer.parseInt(textField.getText()));
					table.setModel(tablemodel);
					table.setVisible(true);
				}
			}
		});
		btnNewButton_2.setBounds(562, 167, 263, 56);
		getContentPane().add(btnNewButton_2);
		
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u53F7");
		lblNewLabel.setBounds(64, 181, 71, 50);
		getContentPane().add(lblNewLabel);
	}
	
	static class TableModel extends AbstractTableModel{
		
		public enum Model{
			SELECTEDID,ALL
		}
		
		String[] columntitle={"员工编号","员工姓名","销售总额"};
		static int row = Query.numberOfEmployee();
		List<Employee> employeelist=Query.queryAllEmployee();
		Object data[][]=new Object[row][3];
		
		public TableModel(){}
		
		public  void changeData(int id){
			switch(id){
				case 0:
					row = Query.numberOfEmployee();
					for(int i=0;i<row;i++){
						data[i][0]=employeelist.get(i).getId();
						data[i][1]=employeelist.get(i).getName();
						data[i][2]=Query.querySalesAmountByEmployId(employeelist.get(i).getId());
					}
					break;
				default:
					for(int i=0;i<row;i++){
						if((employeelist.get(i).getId())==id){
							data[0][0]=employeelist.get(i).getId();
							data[0][1]=employeelist.get(i).getName();
							data[0][2]=Query.querySalesAmountByEmployId(employeelist.get(i).getId());
							break;
						}	
					}
					row=1;			
			}
		}
		
		@Override  
	    public String getColumnName(int column)  
	    {  
	            return columntitle[column];  
	    }  
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return columntitle.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return row;
		}

		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return data[row][column];
		}
		
		public static int getRowBySelectedEmployeeId(){
			
			return row;
		}
		
		public   boolean   isCellEditable(int   rowIndex,   int   columnIndex){     			     
			return   true;         
		}	
	}
}
