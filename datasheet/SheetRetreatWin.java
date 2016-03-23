package datasheet;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import login.Goods;
import login.Retreat;
import dbsystem.Query;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;


import java.awt.Color;


public class SheetRetreatWin extends JFrame{
	private JTable table;
	private JTable table_1;
	public SheetRetreatWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 1018,751 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("退货表");
		getContentPane().setLayout(null);
		

		TableModel tablemodel=new TableModel();
		JTable table = new JTable(tablemodel);
		table.setBounds(14, 229, 880, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setVisible(true);
		scrollPane.setSize(972, 678);
		scrollPane.setLocation(14, 13);
		getContentPane().add(scrollPane);
		
		
	
	}
	
	static class TableModel extends AbstractTableModel{
		
		String[] columntitle={"退货编号","厂商","商品名","型号","单价","数量","总金额","退货年","退货月","退货日","业务员编号"};
		List<Retreat> retreatlist=Query.queryAllRetreat();
		int row=Query.numberOfRetreat();

		Object data[][]=new Object[row][11];	
		public TableModel(){				
			for(int i=0;i<row;i++){
				data[i][0]=retreatlist.get(i).getId();
	            data[i][1]=retreatlist.get(i).getManufact();
	            data[i][2]=retreatlist.get(i).getName();
	            data[i][3]=retreatlist.get(i).getModel();
	            data[i][4]=retreatlist.get(i).getUnivalent();
	            data[i][5]=retreatlist.get(i).getAmount();
	            data[i][6]=retreatlist.get(i).getTotalmoney();
	            data[i][7]=retreatlist.get(i).getYear();
	            data[i][8]=retreatlist.get(i).getMonth();
	            data[i][9]=retreatlist.get(i).getDay();
	            data[i][10]=retreatlist.get(i).getEmployeeid();	    	
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
	}
}
