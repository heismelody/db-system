package tradeadmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import login.Goods;
import login.Sell;
import dbsystem.Update;

public class SellAdminWin extends JFrame 
implements ActionListener{
	private JTextField idtextField;
	private JTextField manutextField;
	private JTextField unittextField;
	private JTextField nametextField;
	private JTextField typetextField;
	private JTextField amounttextField;
	private JTextField manidtextField;
	private JTextField totaltextField;
	private JTextField yeartextField;
	private JTextField monthtextField;
	private JTextField daytextField;
	private JButton sellButton = new JButton("\u9500\u552E");
	private JButton cancleButton = new JButton("\u6E05\u9664\u91CD\u586B");
	public SellAdminWin(){
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("œ˙ €µ«º«");
		getContentPane().setLayout(null);
		
		idtextField = new JTextField();
		idtextField.setBounds(149, 67, 200, 50);
		getContentPane().add(idtextField);
		idtextField.setColumns(10);
		
		manutextField = new JTextField();
		manutextField.setBounds(149, 160, 200, 50);
		getContentPane().add(manutextField);
		manutextField.setColumns(10);
		
		unittextField = new JTextField();
		unittextField.setBounds(149, 257, 200, 50);
		getContentPane().add(unittextField);
		unittextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setBounds(573, 67, 200, 50);
		getContentPane().add(nametextField);
		nametextField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(573, 160, 200, 50);
		getContentPane().add(typetextField);
		typetextField.setColumns(10);
		
		amounttextField = new JTextField();
		amounttextField.setBounds(573, 257, 200, 50);
		getContentPane().add(amounttextField);
		amounttextField.setColumns(10);
		
		manidtextField = new JTextField();
		manidtextField.setBounds(176, 427, 200, 50);
		getContentPane().add(manidtextField);
		manidtextField.setColumns(10);
		
		totaltextField = new JTextField();
		totaltextField.setBounds(573, 427, 200, 50);
		getContentPane().add(totaltextField);
		totaltextField.setColumns(10);
		
		yeartextField = new JTextField();
		yeartextField.setBounds(214, 345, 106, 50);
		getContentPane().add(yeartextField);
		yeartextField.setColumns(10);
		
		monthtextField = new JTextField();
		monthtextField.setBounds(438, 345, 100, 50);
		getContentPane().add(monthtextField);
		monthtextField.setColumns(10);
		
		daytextField = new JTextField();
		daytextField.setBounds(673, 345, 100, 50);
		getContentPane().add(daytextField);
		daytextField.setColumns(10);
		
		
		sellButton.setBounds(186, 500, 186, 55);
		getContentPane().add(sellButton);
		sellButton.addActionListener(this);
	
		cancleButton.setBounds(521, 500, 186, 55);
		getContentPane().add(cancleButton);
		cancleButton.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7");
		lblNewLabel.setBounds(29, 67, 100, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u751F\u4EA7\u5382\u5546");
		label.setBounds(29, 160, 100, 50);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5355\u4EF7");
		label_1.setBounds(29, 257, 100, 50);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u9500\u552E\u65E5\u671F");
		label_2.setBounds(29, 345, 100, 50);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74");
		label_3.setBounds(143, 345, 57, 50);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u6708");
		label_4.setBounds(367, 345, 57, 50);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u65E5");
		label_5.setBounds(602, 345, 57, 50);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u6570\u91CF");
		label_6.setBounds(467, 257, 100, 50);
		getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u578B\u53F7");
		label_7.setBounds(467, 160, 100, 50);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u5546\u54C1\u540D\u79F0");
		label_8.setBounds(467, 67, 100, 50);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u4E1A\u52A1\u5458\u7F16\u53F7");
		label_9.setBounds(70, 427, 100, 50);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u603B\u91D1\u989D");
		label_10.setBounds(467, 427, 100, 50);
		getContentPane().add(label_10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sellButton){
			Sell goods=new Sell();
			
			goods.setId(Integer.parseInt(idtextField.getText()));
			goods.setManufact(manutextField.getText());
			goods.setName(nametextField.getText());
			goods.setModel(typetextField.getText());
			goods.setUnivalent(Integer.parseInt(unittextField.getText()));
			goods.setAmount(Integer.parseInt(amounttextField.getText()));
			goods.setTotalmoney(Integer.parseInt(totaltextField.getText()));
			goods.setYear(Integer.parseInt(yeartextField.getText()));
			goods.setMonth(Integer.parseInt(monthtextField.getText()));
			goods.setDay(Integer.parseInt(daytextField.getText()));
			goods.setEmployeeid(Integer.parseInt(manidtextField.getText()));
			
			Update.insertGood(goods);
		}
		if(e.getSource()==cancleButton){
			idtextField.setText("");
			manutextField.setText("");
			nametextField.setText("");
			typetextField.setText("");
			unittextField.setText("");
			amounttextField.setText("");
			totaltextField.setText("");
			yeartextField.setText("");
			monthtextField.setText("");
			daytextField.setText("");
			manidtextField.setText("");
		}
	}
	
}
