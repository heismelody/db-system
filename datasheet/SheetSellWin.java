package datasheet;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.AbstractTableModel;

import login.Retreat;
import login.Sell;
import datasheet.SheetRetreatWin.TableModel;
import dbsystem.Query;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SheetSellWin extends JFrame{
	private JTextField nametextField;
	private JTextField modeltextField;
	public SheetSellWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 1017,742 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("已销售货表");
		getContentPane().setLayout(null);
		
		TableModel tablemodel=new TableModel();
		JTable table = new JTable(tablemodel);
		table.setBounds(14, 229, 880, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setVisible(false);
		scrollPane.setSize(971, 488);
		scrollPane.setLocation(14, 194);
		getContentPane().add(scrollPane);
		
		JButton showButton = new JButton("\u663E\u793A\u5DF2\u552E\u5168\u90E8\u5546\u54C1");
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.setVisible(true);
			}
		});
		showButton.setBounds(242, 37, 165, 57);
		getContentPane().add(showButton);
		
		nametextField = new JTextField();
		nametextField.setBounds(156, 137, 165, 35);
		getContentPane().add(nametextField);
		nametextField.setColumns(10);
		
		modeltextField = new JTextField();
		modeltextField.setBounds(449, 137, 150, 35);
		getContentPane().add(modeltextField);
		modeltextField.setColumns(10);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String modeltext=modeltextField.getText();
				String nametext=nametextField.getText();
				if(modeltext.equals("")==true&&nametext.equals("")==true){}
				else 
					if(modeltext.equals("")==true&&nametext.equals("")==false){
						((TableModel) table.getModel()).clearData();
						((TableModel) table.getModel()).changeDataByName(nametext);
						table.setVisible(true);
					}
					else
						if(modeltext.equals("")==false&&nametext.equals("")==true){
							((TableModel) table.getModel()).clearData();
							((TableModel) table.getModel()).changeDataByModel(modeltext);
							table.setVisible(true);
						}
						else
							((TableModel) table.getModel()).clearData();
							((TableModel) table.getModel()).changeDataByNameNModel(nametext,modeltext);
							table.setVisible(true);
			}
		});
		queryButton.setBounds(680, 124, 305, 57);
		getContentPane().add(queryButton);
		
		JLabel label = new JLabel("\u5546\u54C1\u540D");
		label.setBounds(70, 145, 72, 18);
		getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u578B\u53F7");
		lblNewLabel.setBounds(335, 145, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JButton canclebutton = new JButton("\u53D6\u6D88");
		canclebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametextField.setText("");
				modeltextField.setText("");
				((TableModel) table.getModel()).clearData();
				table.setVisible(false);
			}
		});
		canclebutton.setBounds(667, 37, 165, 57);
		getContentPane().add(canclebutton);
	}
	
	static class TableModel extends AbstractTableModel{
		
		String[] columntitle={"商品编号","厂商","商品名","型号","单价","数量","总金额","销售年","销售月","销售日","业务员编号"};
		List<Sell> selllist=Query.queryAllSell();
		static int row=Query.numberOfSell();

		static Object data[][]=new Object[row][11];	
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
		
		public void changeDataByName(String name){
			List<Sell> selllist=Query.querySellByName(name);
			row=Query.numberOfSellOfSameName(name);
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
		
		public void changeDataByModel(String model){
			List<Sell> selllist=Query.querySellByModel(model);
			row=Query.numberOfSellOfSameModel(model);
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
			fireTableDataChanged();
		}
		
		public void changeDataByNameNModel(String name,String model){
			List<Sell> selllist=Query.querySellByNameNModel(name,model);
			row=Query.numberOfSellOfSameNameNModel(name,model);
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
			fireTableDataChanged();
		}
		
		public void clearData(){
			for(int i=0;i<row;i++){
				for(int j=0;j<11;j++){
					data[i][j]=null;
					fireTableCellUpdated(i, j);
				}
	        }
		}
	}
}
