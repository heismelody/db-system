package dbsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Toolkit;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import datasheet.*;
import performance.*;
import purchase.*;
import login.*;
import sales.*;
import tradeadmin.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * It is the main window of this system.
 * It consists of six parts:login in;trade
 *  administered;purchase statistics;sales
 *  statistics;data sheet.
 */
@SuppressWarnings("serial")
public class MainWin extends JFrame 
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWin frame = new MainWin();
					
					 try
					    {
					        //Set the required look and feel
					        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					        //Update the component tree - associate the look and feel with the given frame.
					        SwingUtilities.updateComponentTreeUI(frame);
					    }//end try
					    catch(Exception ex)
					    {
					        ex.printStackTrace();
					    }//end catch
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\study\\dbsystem\\dbsystem\\dbsystem\\system_file_manager.png"));
		setTitle("\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1224, 724);
		
		JMenuBar JMBmain = new JMenuBar();
		setJMenuBar(JMBmain);
		
		//登陆系统菜单键
		JMenu JMlogin = new JMenu("登陆系统");  
		JMBmain.add(JMlogin);		
			JMenuItem JMIlogin_login = new JMenuItem("登陆");
			JMlogin.add(JMIlogin_login);
			JMIlogin_login.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					LogininWin LLlogin=new LogininWin();
				}				
			});
		
			JMenuItem JMIlogin_addusr = new JMenuItem("添加用户");
			JMlogin.add(JMIlogin_addusr);
			JMIlogin_addusr.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {			
					LoginAddusrWin LAaddusr=new LoginAddusrWin();
				}				
			});
			
			JMenuItem JMIlogin_changepw = new JMenuItem("修改密码");
			JMlogin.add(JMIlogin_changepw);
			JMIlogin_changepw.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					LoginChangepwWin LCchangepw=new LoginChangepwWin();
				}				
			});
		
			JMenuItem JMIlogin_exit = new JMenuItem("退出");
			JMlogin.add(JMIlogin_exit);
			//退出按钮，直接退出
			JMIlogin_exit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}				
			});
			
		//交易管理菜单键
		JMenu JMtradeadmin = new JMenu("交易管理");   
		JMBmain.add(JMtradeadmin);		
			JMenuItem JMIadmin_purchase = new JMenuItem("进货登记");
			JMtradeadmin.add(JMIadmin_purchase);
			JMIadmin_purchase.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					StockAdminWin SAdmin=new StockAdminWin();
				}				
			});
		
			JMenuItem JMIadmin_sales = new JMenuItem("销售登记");
			JMtradeadmin.add(JMIadmin_sales);
			JMIadmin_sales.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					SellAdminWin SAdmin=new SellAdminWin();
				}				
			});
		
			JMenuItem JMIadmin_retire = new JMenuItem("退货登记");
			JMtradeadmin.add(JMIadmin_retire);
			JMIadmin_retire.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					ReturnAdminWin RAdmin=new ReturnAdminWin();
				}				
			});
			
		//进货统计菜单键
		JMenu JMpurchase = new JMenu("进货统计");      
		JMBmain.add(JMpurchase);	
			JMenuItem JMIpur_today = new JMenuItem("今日进货量");
			JMpurchase.add(JMIpur_today);
			JMIpur_today.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					PurchaseWin Ppurchase=new PurchaseWin();
				}				
			});
			
			JMenuItem JMIpur_month = new JMenuItem("本月进货量");
			JMpurchase.add(JMIpur_month);
			JMIpur_month.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					PurchaseWin Ppurchase=new PurchaseWin();
				}				
			});
		
			JMenuItem JMIpur_quarter = new JMenuItem("本季度进货量");
			JMpurchase.add(JMIpur_quarter);
			JMIpur_quarter.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					PurchaseWin Ppurchase=new PurchaseWin();
				}				
			});
		
			JMenuItem JMIpur_year = new JMenuItem("今年进货量");
			JMpurchase.add(JMIpur_year);
			JMIpur_year.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					PurchaseWin Ppurchase=new PurchaseWin();
				}				
			});
			
		//销售统计菜单键
		JMenu JMsales = new JMenu("销售统计");    
		JMBmain.add(JMsales);	
			JMenuItem JMIsales_today = new JMenuItem("今日销售量");
			JMsales.add(JMIsales_today);
			JMIsales_today.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					SalesWin Ssales=new SalesWin();
				}				
			});
		
			JMenuItem JMIsales_month = new JMenuItem("本月销售量");
			JMsales.add(JMIsales_month);
			JMIsales_month.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					SalesWin Ssales=new SalesWin();
				}				
			});
		
			JMenuItem JMIsales_quarter = new JMenuItem("本季度销售量");
			JMsales.add(JMIsales_quarter);
			JMIsales_quarter.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					SalesWin Ssales=new SalesWin();
				}				
			});
		
			JMenuItem JMIsales_year = new JMenuItem("今年销售量");
			JMsales.add(JMIsales_year);
			JMIsales_year.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					SalesWin Ssales=new SalesWin();
				}				
			});
			
		//业绩查看菜单键
		JMenu JMperformance = new JMenu("业绩查看"); 
		JMBmain.add(JMperformance);  
		JMperformance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PerformanceWin P=new PerformanceWin();
			}
		});
		
		
		
		//查看数据表菜单键
		JMenu JMdatasheet = new JMenu("查看数据表");   
		JMBmain.add(JMdatasheet);		
			JMenuItem JMIsheet_stock = new JMenuItem("现存货表");
			JMdatasheet.add(JMIsheet_stock);
			JMIsheet_stock.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SheetRemainWin SRstock=new SheetRemainWin();
				}
			});
		
			JMenuItem JMIsheet_sales = new JMenuItem("已售商品表");
			JMdatasheet.add(JMIsheet_sales);
			JMIsheet_sales.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					SheetSellWin SSsales=new SheetSellWin();
				}
			});
		
			JMenuItem JMIsheet_retire = new JMenuItem("退货表");
			JMdatasheet.add(JMIsheet_retire);
			JMIsheet_retire.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					SheetRetreatWin SRretire=new SheetRetreatWin();
				}
			});
		
			JMenuItem JMIsheet_employ = new JMenuItem("员工表");
			JMdatasheet.add(JMIsheet_employ);
			JMIsheet_employ.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					SheetEmployeeWin SEempoly=new SheetEmployeeWin();
				}
			});
		
			JMenuItem JMIsheet_factor = new JMenuItem("进货商表");
			JMdatasheet.add(JMIsheet_factor);
			JMIsheet_factor.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					SheetManufacWin SMfactor=new SheetManufacWin();
				}
			});
	}
}
