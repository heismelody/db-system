package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dbsystem.Query;
import dbsystem.Update;
import dbsystem.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginAddusrWin extends JFrame 
implements ActionListener{
	private JTextField namefield;
	private JLabel label_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public LoginAddusrWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 825,619 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("添加用户");
		getContentPane().setLayout(null);
		
		namefield = new JTextField();
		namefield.setBounds(267, 102, 288, 53);
		getContentPane().add(namefield);
		namefield.setColumns(10);
		
		JLabel label = new JLabel("\u8F93\u5165\u7528\u6237\u540D");
		label.setBounds(84, 119, 120, 30);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5BC6\u7801");
		label_1.setBounds(84, 242, 120, 30);
		getContentPane().add(label_1);
		
		label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(84, 369, 120, 30);
		getContentPane().add(label_2);
		
		btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(158, 478, 113, 27);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBounds(425, 478, 113, 27);
		getContentPane().add(btnNewButton_1);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(267, 242, 288, 50);
		getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(267, 369, 288, 50);
		getContentPane().add(passwordField_1);
	}

	public void  cancle() {
	    Object[] options = { "确定", "取消" };
	    JOptionPane pane2 = new JOptionPane("真想退出吗?", JOptionPane.QUESTION_MESSAGE,
	        JOptionPane.YES_NO_OPTION, null, options, options[1]);
	    JDialog dialog = pane2.createDialog(this, "警告");
	    dialog.setVisible(true);
	    Object selectedValue = pane2.getValue();
	    if (selectedValue == null || selectedValue == options[1]) {
	      setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // 这个是关键
	    } else if (selectedValue == options[0]) {
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    }
	  }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int i;
		String name=namefield.getText();
		String password=new String(passwordField.getPassword());
		String pwconfirm=new String(passwordField_1.getPassword());
		for(i=1;Query.queryIdExist(i)==true;i++){}
			Update.insertNamePw(i, name, password);
			this.setVisible(false);
	}
}
