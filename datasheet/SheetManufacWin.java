package datasheet;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import login.Manufact;
import dbsystem.Query;
import dbsystem.Update;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SheetManufacWin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	public SheetManufacWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("进货商表");
		getContentPane().setLayout(null);
		
		TableModel tablemodel=new TableModel();
		table = new JTable(tablemodel);
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
				String deleterepresent=table.getValueAt(rowindex,2).toString();
				String deletetele = table.getValueAt(rowindex,3).toString();
				String deleteaddress = table.getValueAt(rowindex,4).toString();
				
				Update.updateManufact(Integer.parseInt(deleteid),deletename,deleterepresent, deletetele, deleteaddress);
				
			}
		});
		btnNewButton.setBounds(218, 530, 166, 56);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u8BB0\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowindex=table.getSelectedRow();
				String deleteid = table.getValueAt(rowindex,0).toString();
				
				Update.deleteManufactById(Integer.parseInt(deleteid));
				
				((datasheet.SheetManufacWin.TableModel) table.getModel()).removeRow(rowindex);
				//((TableModel) table.getModel()).fireTableRowsDeleted(rowindex, rowindex);
			}
		});
		btnNewButton_1.setBounds(502, 530, 166, 56);
		getContentPane().add(btnNewButton_1);
	}
	
	static class TableModel extends AbstractTableModel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String[] columntitle={"厂商编号","厂商名称","法人代表","电话","厂商地址"};
		List<Manufact> manufactlist=Query.queryAllManufact();
		int row=Query.numberOfManufact();

		Object data[][]=new Object[row][5];	
		public TableModel(){				
			for(int i=0;i<row;i++){
				data[i][0]=manufactlist.get(i).getId();
	            data[i][1]=manufactlist.get(i).getName();
	            data[i][2]=manufactlist.get(i).getRepresent();
	            data[i][3]=manufactlist.get(i).getTele();
	            data[i][4]=manufactlist.get(i).getAddress();
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
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			
			return data[row][column]; 
		}
		
		@Override
		public   boolean   isCellEditable(int   rowIndex,   int  columnIndex){     
			return   true;
		}
		
		public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
        {  
            data[rowIndex][columnIndex] = aValue;
            fireTableCellUpdated(rowIndex, columnIndex);  
        }
		
		public void removeRow(int rowindex){
			
			for(int i=rowindex;i<row;i++){
				for(int j=0;j<5;j++)
					if(i!=row-1){data[i][j]=data[i+1][j];}
					else data[i][j]=null;
	        }
			row--;
			this.fireTableDataChanged();
		}
	}
}
