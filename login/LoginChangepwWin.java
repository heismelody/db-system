package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import dbsystem.Query;
import dbsystem.Update;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginChangepwWin extends JFrame 
implements ActionListener{
	private JPasswordField oldpasswordField;
	private JPasswordField newpasswordField;
	private JPasswordField newPWconfirmField;
	private JTextField nametextField;
	/**
	 * Create the frame.
	 */
	public LoginChangepwWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 926,674 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("¸ü¸ÄÃÜÂë");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(122, 96, 130, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F93\u5165\u65B0\u5BC6\u7801");
		lblNewLabel_1.setBounds(122, 254, 130, 33);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801");
		lblNewLabel_2.setBounds(122, 358, 130, 33);
		getContentPane().add(lblNewLabel_2);
		
		JButton confirmButton = new JButton("\u786E\u5B9A");
		confirmButton.setBounds(151, 499, 118, 53);
		getContentPane().add(confirmButton);
		confirmButton.addActionListener(this);
		
		JButton cancleButton = new JButton("\u53D6\u6D88");
		cancleButton.setBounds(541, 495, 130, 60);
		getContentPane().add(cancleButton);
		
		JLabel label = new JLabel("\u8F93\u5165\u539F\u5BC6\u7801");
		label.setBounds(122, 177, 130, 33);
		getContentPane().add(label);
		
		oldpasswordField = new JPasswordField();
		oldpasswordField.setBounds(289, 163, 348, 60);
		getContentPane().add(oldpasswordField);
		
		newpasswordField = new JPasswordField();
		newpasswordField.setBounds(289, 240, 348, 60);
		getContentPane().add(newpasswordField);
		
		newPWconfirmField = new JPasswordField();
		newPWconfirmField.setBounds(289, 344, 348, 60);
		getContentPane().add(newPWconfirmField);
		
		nametextField = new JTextField();
		nametextField.setBounds(289, 87, 346, 50);
		getContentPane().add(nametextField);
		nametextField.setColumns(10);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name=nametextField.getText();
		String oldpw=new String(oldpasswordField.getPassword());
		String newpw=new String(newpasswordField.getPassword());
		String newpwconfirm=new String(newPWconfirmField.getPassword());
		if(oldpw.equals(Query.queryPwByName(name))){
			Update.changePwByName(name, newpw);
			this.setVisible(false);
		}	
	}
}
