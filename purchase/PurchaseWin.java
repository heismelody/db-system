package purchase;

import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.table.AbstractTableModel;

import dbsystem.Query;
import login.Goods;

public class PurchaseWin extends JFrame{
	public PurchaseWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 1020,726 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("进货统计");
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(14, 13, 974, 653);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.DAY);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.MONTH);
		JTable table = new JTable(new TableModel());
		JScrollPane scrollPane = new JScrollPane(table);
		tabbedPane.addTab("本日进货", null, scrollPane, null);
		JTable table1 = new JTable(new TableModel());
		JScrollPane scrollPane1 = new JScrollPane(table1);
		tabbedPane.addTab("本月进货", null, scrollPane1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.QUARTER);
		JTable table2 = new JTable(new TableModel());
		JScrollPane scrollPane2 = new JScrollPane(table2);
		tabbedPane.addTab("本季度进货", null, scrollPane2, null);
		
		JPanel panel_3 = new JPanel();	
		panel_3.setLayout(null);
		TableModel.getRowByTimeType(Query.Time.YEAR);
		JTable table3 = new JTable(new TableModel());
		JScrollPane scrollPane3 = new JScrollPane(table3);
		tabbedPane.addTab("今年进货", null, scrollPane3, null);
	}
	
	static class TableModel extends AbstractTableModel{
		
		String[] columntitle={"商品编号","生产厂商","商品名","型号","单价","数量","总金额","进货年","进货月","进货日","业务员编号"};
		List<Goods> goodslist=Query.queryAllGoods();
		static int goodsrowday=Query.numberOfGoods(Query.Time.DAY);
		static int goodsrowmonth=Query.numberOfGoods(Query.Time.MONTH);
		static int goodsrowquarter=Query.numberOfGoods(Query.Time.QUARTER);
		static int goodsrowyear=Query.numberOfGoods(Query.Time.YEAR);
		static int row;
		
		Object data[][]=new Object[row][11];	
		public TableModel(){				
			for(int i=0;i<row;i++){
				data[i][0]=goodslist.get(i).getId();
	            data[i][1]=goodslist.get(i).getManufact();
	            data[i][2]=goodslist.get(i).getName();
	            data[i][3]=goodslist.get(i).getModel();
	            data[i][4]=goodslist.get(i).getUnivalent();
	            data[i][5]=goodslist.get(i).getAmount();
	            data[i][6]=goodslist.get(i).getTotalmoney();
	            data[i][7]=goodslist.get(i).getYear();
	            data[i][8]=goodslist.get(i).getMonth();
	            data[i][9]=goodslist.get(i).getDay();
	            data[i][10]=goodslist.get(i).getEmployeeid();	    	
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
				row=goodsrowday;
				break;
			case MONTH:
				row=goodsrowmonth;
				break;
			case QUARTER:
				row=goodsrowquarter;
				break;
			case YEAR:
				row=goodsrowyear;
				break;	
			}
			return row;
		}
		
	}
	
}
