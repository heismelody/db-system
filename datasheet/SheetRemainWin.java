package datasheet;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import login.Remains;
import dbsystem.Query;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SheetRemainWin extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table=new JTable();
	private JTextField textField;
	private JTextField textField_1;
	
	private int row = Query.numberOfRemains();
	private Object data[][]=new Object[row][11];
	private List<Remains> remainlist=Query.queryAllRemains();
	
	public SheetRemainWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 1026,761 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("œ÷¥Êªı±Ì");
		getContentPane().setLayout(null);
		
		for(int i=0;i<row;i++){
			data[i][0]=remainlist.get(i).getId();
	        data[i][1]=remainlist.get(i).getManufact();
	        data[i][2]=remainlist.get(i).getName();
	        data[i][3]=remainlist.get(i).getModel();
	        data[i][4]=remainlist.get(i).getUnivalent();
	        data[i][5]=remainlist.get(i).getAmount();
	        data[i][6]=remainlist.get(i).getTotalmoney();
	        data[i][7]=remainlist.get(i).getYear();
	        data[i][8]=remainlist.get(i).getMonth();
	        data[i][9]=remainlist.get(i).getDay();
	        data[i][10]=remainlist.get(i).getEmployeeid();	    	
	    }
		
		table.setBounds(14, 229, 880, 385);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setVisible(true);
		scrollPane.setSize(980, 521);
		scrollPane.setLocation(14, 180);
		getContentPane().add(scrollPane);
		
		table.setModel(new DefaultTableModel(
					data,
					new String[] {
				"\u5546\u54C1\u7F16\u53F7", "\u751F\u4EA7\u5382\u5546", 
				"\u5546\u54C1\u540D", "\u578B\u53F7", "\u5355\u4EF7", 
				"\u6570\u91CF", "\u603B\u91D1\u989D", "\u8FDB\u8D27\u5E74", 
				"\u8FDB\u8D27\u6708", "\u8FDB\u8D27\u65E5", "\u4E1A\u52A1\u5458\u7F16\u53F7"
					}
		));	
		table.setBounds(14, 252, 880, 362);
		table.setVisible(false);
		
		JButton btnNewButton = new JButton("\u663E\u793A\u5168\u90E8\u73B0\u5B58\u5546\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				table.setVisible(true);
			}
		});
		btnNewButton.setBounds(119, 25, 185, 71);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setVisible(false);
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton_1.setBounds(665, 25, 185, 71);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_2.setBounds(706, 115, 185, 59);
		getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(167, 121, 159, 47);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(498, 121, 167, 47);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u540D");
		lblNewLabel.setBounds(51, 135, 72, 18);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u578B\u53F7");
		lblNewLabel_1.setBounds(396, 135, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
	}
}
