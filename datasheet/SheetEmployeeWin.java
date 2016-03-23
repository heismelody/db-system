package datasheet;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import login.Employee;
import login.Retreat;
import datasheet.SheetRetreatWin.TableModel;
import dbsystem.Query;
import dbsystem.Update;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SheetEmployeeWin extends JFrame{
	private JTable table;
	public SheetEmployeeWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("员工表");
		getContentPane().setLayout(null);
		
		TableModel tablemodel=new TableModel();
		JTable table = new JTable(tablemodel);
		table.setBounds(14, 229, 880, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setVisible(true);
		scrollPane.setSize(880, 495);
		scrollPane.setLocation(14, 13);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u8BB0\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String deleteid = table.getValueAt(rowindex,0).toString();
				String deletename = table.getValueAt(rowindex,1).toString();
				String deletetele = table.getValueAt(rowindex,2).toString();
				String deleteaddress = table.getValueAt(rowindex,3).toString();
				
				Update.updateEmployee(Integer.parseInt(deleteid), deletename, deletetele, deleteaddress);
			}
		});
		btnNewButton.setBounds(99, 533, 226, 62);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u8BB0\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int rowindex=table.getSelectedRow();
				String deleteid = table.getValueAt(rowindex,0).toString();
				
				Update.deleteEmployeeById(Integer.parseInt(deleteid));
				((datasheet.SheetManufacWin.TableModel) table.getModel()).removeRow(rowindex);
			}
		});
		btnNewButton_1.setBounds(528, 533, 226, 63);
		getContentPane().add(btnNewButton_1);
	}
	
	static class TableModel extends AbstractTableModel{
		
		String[] columntitle={"员工编号","员工姓名","员工电话","员工地址"};
		List<Employee> employeelist=Query.queryAllEmployee();
		int row=Query.numberOfEmployee();

		Object data[][]=new Object[row][4];	
		public TableModel(){				
			for(int i=0;i<row;i++){
				data[i][0]=employeelist.get(i).getId();
	            data[i][1]=employeelist.get(i).getName();
	            data[i][2]=employeelist.get(i).getTele();
	            data[i][3]=employeelist.get(i).getAddress();	
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
			return data.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
			return data[rowIndex][columnIndex]; 
		}
		
		@Override
		public   boolean   isCellEditable(int   rowIndex,   int  columnIndex){     
			return   true;
		}
		
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
        {  
            data[rowIndex][columnIndex] = aValue;  
            /*通知监听器数据单元数据已经改变*/  
            fireTableCellUpdated(rowIndex, columnIndex);  
        }
		
		public void removeRow(int rowindex){
			for(int i=rowindex;i<row;i++){
				for(int j=0;j<5;j++)
					if(i!=row-1){data[i][j]=data[i+1][j];}
					else data[i][j]=null;
	        }
			this.fireTableRowsDeleted(rowindex, rowindex);
			row=row-1;
			this.fireTableDataChanged();
		}
	}
}
