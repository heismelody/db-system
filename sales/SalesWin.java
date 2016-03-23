package sales;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import login.Goods;
import login.Sell;
import dbsystem.Query;

public class SalesWin extends JFrame{
	public SalesWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 1015,737 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("销售统计");
		getContentPane().setLayout(null);
		

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 13, 969, 664);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.DAY);
		JTable table = new JTable(new TableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("今日销售", null, scrollPane, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.MONTH);
		JTable table1 = new JTable(new TableModel());
		JScrollPane scrollPane1 = new JScrollPane(table1);
		tabbedPane.addTab("本月销售", null, scrollPane1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.QUARTER);
		JTable table2 = new JTable(new TableModel());
		JScrollPane scrollPane2 = new JScrollPane(table2);
		tabbedPane.addTab("本季度销售", null, scrollPane2, null);
		
		JPanel panel_3 = new JPanel();	
		panel_3.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.YEAR);
		JTable table3 = new JTable(new TableModel());
		JScrollPane scrollPane3 = new JScrollPane(table3);
		tabbedPane.addTab("今年销售", null, scrollPane3, null);
	}
	
	private static class TableModel extends AbstractTableModel{
		
		String[] columntitle={"商品编号","生产厂商","商品名","型号","单价","数量","总金额","进货年","进货月","进货日","业务员编号"};
		List<Sell> selllist=Query.queryAllSell();
		static int sellrowday=Query.numberOfSell(Query.Time.DAY);
		static int sellrowmonth=Query.numberOfSell(Query.Time.MONTH);
		static int sellrowquarter=Query.numberOfSell(Query.Time.QUARTER);
		static int sellrowyear=Query.numberOfSell(Query.Time.YEAR);
		static int row;
		
		Object data[][]=new Object[row][11];	
		public TableModel(){				
			for(int i=0;i<row;i++){
				data[i][0]=selllist.get(i).getId();
	            data[i][1]=selllist.get(i).getManufact();
	            data[i][2]=selllist.get(i).getName();
	            data[i][3]=selllist.get(i).getModel();
	            data[i][4]=selllist.get(i).getUnivalent();
	            data[i][5]=selllist.get(i).getAmount();
	            data[i][6]=selllist.get(i).getTotalmoney();
	            data[i][7]=selllist.get(i).getYear();
	            data[i][8]=selllist.get(i).getMonth();
	            data[i][9]=selllist.get(i).getDay();
	            data[i][10]=selllist.get(i).getEmployeeid();	    	
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
		
		public static int getRowByTimeType(Query.Time time){
			switch(time){
			case DAY:
				row=sellrowday;
				break;
			case MONTH:
				row=sellrowmonth;
				break;
			case QUARTER:
				row=sellrowquarter;
				break;
			case YEAR:
				row=sellrowyear;
				break;	
			}
			return row;
		}
		
	}
}
