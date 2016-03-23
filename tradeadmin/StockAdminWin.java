package tradeadmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import dbsystem.Update;
import login.Goods;
import login.Manufact;

public class StockAdminWin extends JFrame
implements ActionListener{
	private JTextField idtextField;
	private JTextField manutextField;
	private JTextField unittextField;
	private JTextField yeartextField;
	private JTextField monthtextField;
	private JTextField daytextField;
	private JTextField nametextField;
	private JTextField typetextField;
	private JTextField amounttextField;
	private JTextField manidtextField;
	private JTextField totaltextField;
	private JTextField manunameField;
	private JTextField representField;
	private JTextField teleField;
	private JTextField adressField;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JButton goodinButton = new JButton("\u6DFB\u52A0\u5165\u5E93");
	private JButton cancleButton1 = new JButton("\u6E05\u9664\u91CD\u586B");
	private JButton manuButton = new JButton("\u6DFB\u52A0\u5165\u5E93");
	private JButton cancleButton2 = new JButton("\u6E05\u9664\u91CD\u586B");
	public StockAdminWin(){
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("添加商品入库");
		getContentPane().setLayout(null);
		
		idtextField = new JTextField();
		idtextField.setBounds(126, 23, 280, 50);
		getContentPane().add(idtextField);
		idtextField.setColumns(10);
		
		manutextField = new JTextField();
		manutextField.setBounds(126, 106, 280, 50);
		getContentPane().add(manutextField);
		manutextField.setColumns(10);
		
		unittextField = new JTextField();
		unittextField.setBounds(129, 187, 277, 50);
		getContentPane().add(unittextField);
		unittextField.setColumns(10);
		
		yeartextField = new JTextField();
		yeartextField.setBounds(185, 250, 114, 50);
		getContentPane().add(yeartextField);
		yeartextField.setColumns(10);
		
		monthtextField = new JTextField();
		monthtextField.setBounds(409, 250, 100, 50);
		getContentPane().add(monthtextField);
		monthtextField.setColumns(10);
		
		daytextField = new JTextField();
		daytextField.setBounds(621, 250, 114, 50);
		getContentPane().add(daytextField);
		daytextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setBounds(529, 23, 280, 50);
		getContentPane().add(nametextField);
		nametextField.setColumns(10);
		
		typetextField = new JTextField();
		typetextField.setBounds(529, 106, 280, 50);
		getContentPane().add(typetextField);
		typetextField.setColumns(10);
		
		amounttextField = new JTextField();
		amounttextField.setBounds(529, 187, 280, 50);
		getContentPane().add(amounttextField);
		amounttextField.setColumns(10);
		
		manidtextField = new JTextField();
		manidtextField.setBounds(218, 313, 200, 44);
		getContentPane().add(manidtextField);
		manidtextField.setColumns(10);
		
		totaltextField = new JTextField();
		totaltextField.setBounds(603, 310, 200, 50);
		getContentPane().add(totaltextField);
		totaltextField.setColumns(10);
		
		
		goodinButton.setBounds(230, 387, 113, 27);
		getContentPane().add(goodinButton);
		goodinButton.addActionListener(this);
		
		cancleButton1.setBounds(570, 387, 113, 27);
		getContentPane().add(cancleButton1);
		cancleButton1.addActionListener(this);
		
		manuButton.setBounds(230, 585, 113, 27);
		getContentPane().add(manuButton);
		manuButton.addActionListener(this);
		
		cancleButton2.setBounds(570, 585, 113, 27);
		getContentPane().add(cancleButton2);
		cancleButton2.addActionListener(this);
		
		
		manunameField = new JTextField();
		manunameField.setBounds(126, 426, 683, 33);
		getContentPane().add(manunameField);
		manunameField.setColumns(10);
		
		representField = new JTextField();
		representField.setBounds(126, 483, 262, 33);
		getContentPane().add(representField);
		representField.setColumns(10);
		
		teleField = new JTextField();
		teleField.setBounds(504, 483, 305, 33);
		getContentPane().add(teleField);
		teleField.setColumns(10);
		
		adressField = new JTextField();
		adressField.setBounds(126, 539, 683, 33);
		getContentPane().add(adressField);
		adressField.setColumns(10);

		
		JLabel label = new JLabel("\u5546\u54C1\u7F16\u53F7");
		label.setBounds(14, 23, 100, 50);
		getContentPane().add(label);
		
		label_1 = new JLabel("\u751F\u4EA7\u5382\u5546");
		label_1.setBounds(14, 106, 100, 50);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("\u5355\u4EF7");
		label_2.setBounds(14, 187, 100, 50);
		getContentPane().add(label_2);
		
		label_3 = new JLabel("\u5546\u54C1\u540D\u79F0");
		label_3.setBounds(424, 23, 100, 50);
		getContentPane().add(label_3);
		
		label_4 = new JLabel("\u578B\u53F7");
		label_4.setBounds(424, 106, 100, 50);
		getContentPane().add(label_4);
		
		label_5 = new JLabel("\u6570\u91CF");
		label_5.setBounds(423, 187, 100, 50);
		getContentPane().add(label_5);
		
		label_6 = new JLabel("\u8FDB\u8D27\u65E5\u671F");
		label_6.setBounds(79, 250, 100, 50);
		getContentPane().add(label_6);
		
		label_7 = new JLabel("\u5E74");
		label_7.setBounds(322, 250, 84, 50);
		getContentPane().add(label_7);
		
		label_8 = new JLabel("\u6708");
		label_8.setBounds(529, 250, 78, 50);
		getContentPane().add(label_8);
		
		label_9 = new JLabel("\u4E1A\u52A1\u5458\u7F16\u53F7");
		label_9.setBounds(112, 307, 100, 50);
		getContentPane().add(label_9);
		
		label_10 = new JLabel("\u603B\u91D1\u989D");
		label_10.setBounds(500, 307, 100, 50);
		getContentPane().add(label_10);
		
		label_11 = new JLabel("\u5382\u5546\u540D\u79F0");
		label_11.setBounds(20, 409, 100, 50);
		getContentPane().add(label_11);
		
		label_12 = new JLabel("\u6CD5\u4EBA\u4EE3\u8868");
		label_12.setBounds(20, 477, 100, 50);
		getContentPane().add(label_12);
		
		label_13 = new JLabel("\u5382\u5546\u5730\u5740");
		label_13.setBounds(14, 533, 100, 50);
		getContentPane().add(label_13);
		
		label_14 = new JLabel("\u7535\u8BDD");
		label_14.setBounds(394, 483, 100, 50);
		getContentPane().add(label_14);
		
		label_15 = new JLabel("\u65E5");
		label_15.setBounds(758, 250, 100, 50);
		getContentPane().add(label_15);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==goodinButton){		
			Goods goods=new Goods();
			
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
		if(e.getSource()==cancleButton1){
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
		if(e.getSource()==manuButton){
			Manufact manu=new Manufact();
			
			manu.setName(manunameField.getText());
			manu.setRepresent(representField.getText());
			manu.setTele(teleField.getText());
			manu.setAddress(adressField.getText());
			
			Update.insertManufacter(manu);
		}
		if(e.getSource()==cancleButton2){
			manunameField.setText("");		
			representField.setText("");	
			teleField.setText("");			
			adressField.setText("");	
		}
		
	}
}
