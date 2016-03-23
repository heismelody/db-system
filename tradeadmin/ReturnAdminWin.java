package tradeadmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import login.Goods;
import login.Retreat;
import dbsystem.Update;

public class ReturnAdminWin extends JFrame
implements ActionListener{
	private JTextField idtextField;
	private JTextField manutextField;
	private JTextField unittextField;
	private JTextField nametextField;
	private JTextField typetextField;
	private JTextField amounttextField;
	private JTextField yeartextField;
	private JTextField monthtextField;
	private JTextField daytextField;
	private JTextField manidtextField;
	private JTextField totaltextField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JButton retreatButton = new JButton("\u9000\u8D27");
	private JButton cancleButton = new JButton("\u6E05\u7A7A\u91CD\u586B");
	public ReturnAdminWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("ÍË»õµÇ¼Ç");
		getContentPane().setLayout(null);
		
		idtextField = new JTextField();
		idtextField.setBounds(166, 57, 164, 49);
		getContentPane().add(idtextField);
		idtextField.setColumns(10);
		
		manutextField = new JTextField();
		manutextField.setBounds(166, 171, 164, 49);
		getContentPane().add(manutextField);
		manutextField.setColumns(10);
		
		unittextField = new JTextField();
		unittextField.setBounds(166, 278, 164, 49);
		getContentPane().add(unittextField);
		unittextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setBounds(640, 63, 144, 49);
		getContentPane().add(nametextField);
		nametextField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(640, 159, 144, 49);
		getContentPane().add(typetextField);
		typetextField.setColumns(10);
		
		amounttextField = new JTextField();
		amounttextField.setBounds(640, 266, 144, 49);
		getContentPane().add(amounttextField);
		amounttextField.setColumns(10);
		
		yeartextField = new JTextField();
		yeartextField.setBounds(135, 401, 144, 49);
		getContentPane().add(yeartextField);
		yeartextField.setColumns(10);
		
		monthtextField = new JTextField();
		monthtextField.setBounds(319, 401, 140, 49);
		getContentPane().add(monthtextField);
		monthtextField.setColumns(10);
		
		daytextField = new JTextField();
		daytextField.setBounds(549, 401, 136, 49);
		getContentPane().add(daytextField);
		daytextField.setColumns(10);
		
		manidtextField = new JTextField();
		manidtextField.setBounds(237, 490, 144, 49);
		getContentPane().add(manidtextField);
		manidtextField.setColumns(10);
		
		totaltextField = new JTextField();
		totaltextField.setBounds(559, 478, 144, 49);
		getContentPane().add(totaltextField);
		totaltextField.setColumns(10);
		
		
		retreatButton.setBounds(150, 552, 152, 46);
		getContentPane().add(retreatButton);
		retreatButton.addActionListener(this);

		cancleButton.setBounds(499, 552, 152, 49);
		getContentPane().add(cancleButton);
		cancleButton.addActionListener(this);
		
		JLabel label = new JLabel("\u9000\u8D27\u7F16\u53F7");
		label.setBounds(67, 72, 72, 18);
		getContentPane().add(label);
		
		lblNewLabel = new JLabel("\u751F\u4EA7\u5382\u5546");
		lblNewLabel.setBounds(67, 177, 72, 18);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u5355\u4EF7");
		lblNewLabel_1.setBounds(67, 281, 72, 18);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u5546\u54C1\u540D\u79F0");
		lblNewLabel_2.setBounds(524, 72, 72, 18);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u5546\u54C1\u578B\u53F7");
		lblNewLabel_3.setBounds(524, 177, 72, 18);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("\u6570\u91CF");
		lblNewLabel_4.setBounds(524, 269, 72, 18);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("\u9000\u8D27\u65E5\u671F\uFF1A");
		lblNewLabel_5.setBounds(14, 418, 86, 32);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("\u5E74");
		lblNewLabel_6.setBounds(114, 418, 72, 18);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u6708");
		lblNewLabel_7.setBounds(283, 418, 72, 18);
		getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("\u65E5");
		lblNewLabel_8.setBounds(473, 418, 72, 18);
		getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("\u4E1A\u52A1\u5458\u7F16\u53F7");
		lblNewLabel_9.setBounds(125, 496, 98, 21);
		getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("\u9000\u8D27\u603B\u91D1\u989D");
		lblNewLabel_10.setBounds(447, 493, 98, 24);
		getContentPane().add(lblNewLabel_10);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==retreatButton){
			Retreat goods=new Retreat();
			
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
