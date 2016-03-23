package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;

import dbsystem.Query;
import dbsystem.Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogininWin extends JFrame 
implements ActionListener{
	private JTextField textField;
	private JTextField namefield;
	private JPasswordField passwordfield;
	/**
	 * Create the frame.
	 */
	public LogininWin() {
		this.setBounds(300, 100, 1224, 724);
		this.setSize( 700,500 );
		this.setDefaultCloseOperation(getDefaultCloseOperation());
		this.setVisible( true );
		this.setTitle("µÇÂ½");
		getContentPane().setLayout(null);
		
		
		JButton loginnbutton = new JButton("\u767B\u5F55");
		loginnbutton.setBounds(98, 354, 200, 50);
		getContentPane().add(loginnbutton);
		loginnbutton.addActionListener(this);
		
		JButton canclebutton = new JButton("\u53D6\u6D88");
		canclebutton.setBounds(347, 354, 200, 50);
		getContentPane().add(canclebutton);
		
		
		namefield = new JTextField();
		namefield.setBounds(265, 123, 200, 50);
		getContentPane().add(namefield);
		namefield.setColumns(10);
		
		passwordfield = new JPasswordField();
		passwordfield.setBounds(265, 236, 200, 50);
		getContentPane().add(passwordfield);
		
			
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\u79F0");
		lblNewLabel_1.setBounds(98, 123, 77, 50);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u5BC6\u7801");
		lblNewLabel_2.setBounds(98, 236, 77, 50);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("\u9500\u552E\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setBounds(209, 43, 279, 50);
		getContentPane().add(lblNewLabel);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=namefield.getText();
		String password=new String(passwordfield.getPassword());
		if((Query.queryNameExist(name)&&Query.queryPwByName(name).equals(password))){
					this.setVisible(false);
				}
	}
}
