package dbsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import login.Employee;
import login.Goods;
import login.Manufact;
import login.Remains;
import login.Retreat;
import login.Sell;

public class Query {
	public enum Time{
		DAY,WEEK,MONTH,QUARTER,YEAR
	}
	
	public static String queryPwByName(String name){
		String password=null;
		String sql="SELECT \"����\" "
					+"FROM userdb "
					+"WHERE \"�û���\"=?";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			rs=pstat.executeQuery();
			while(rs.next()){
				password=rs.getString("����");
			}
					
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return password;
	}
	
	public static boolean queryIdExist(int identity){
		String sql="SELECT * "
					+"From userdb "
					+"WHERE \"�û����\"=?";
					
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, identity);
			rs=pstat.executeQuery();
			if(rs.next()){result=true;}
			else result=false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static boolean queryNameExist(String name){
		String sql="SELECT * "
				+"From userdb "
				+"WHERE \"�û���\"=?";
				
		boolean result=false;
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			rs=pstat.executeQuery();
			if(rs.next()){result=true;}
			else result=false;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static List<Sell> querySellByName(String name){
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"��Ʒ��\"=\""+name+"\" ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
	
		List<Sell> list=new ArrayList<Sell>();
	
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
		
			while(rs.next()){
				Sell sell=new Sell();
			
				sell.setId(rs.getInt("��Ʒ���"));
				sell.setManufact(rs.getString("��������"));
				sell.setName(rs.getString("��Ʒ��"));
				sell.setModel(rs.getString("�ͺ�"));
				sell.setUnivalent(rs.getInt("����"));
				sell.setAmount(rs.getInt("����"));
				sell.setTotalmoney(rs.getInt("�ܽ��"));
				sell.setYear(rs.getInt("������"));
				sell.setMonth(rs.getInt("������"));
				sell.setDay(rs.getInt("������"));
				sell.setEmployeeid(rs.getInt("ҵ��Ա���"));
						
				list.add(sell);
			}
			}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Sell> querySellByModel(String model){
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"�ͺ�\"=\""+model+"\" ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
	
		List<Sell> list=new ArrayList<Sell>();
	
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
		
			while(rs.next()){
				Sell sell=new Sell();
			
				sell.setId(rs.getInt("��Ʒ���"));
				sell.setManufact(rs.getString("��������"));
				sell.setName(rs.getString("��Ʒ��"));
				sell.setModel(rs.getString("�ͺ�"));
				sell.setUnivalent(rs.getInt("����"));
				sell.setAmount(rs.getInt("����"));
				sell.setTotalmoney(rs.getInt("�ܽ��"));
				sell.setYear(rs.getInt("������"));
				sell.setMonth(rs.getInt("������"));
				sell.setDay(rs.getInt("������"));
				sell.setEmployeeid(rs.getInt("ҵ��Ա���"));
						
				list.add(sell);
			}
			}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static int querySalesAmountByEmployId(int id){
		int result=0;
		
		String sql="SELECT sum(\"�ܽ��\") "
					+"FROM SELL,EMPLOYEE "
					+"WHERE SELL.ҵ��Ա��� = EMPLOYEE.Ա����� AND SELL.ҵ��Ա��� = 1 ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			result=rs.getInt("sum(\"�ܽ��\")");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static List<Goods> queryAllGoods(){
		String sql="Select * from Goods ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Goods> list=new ArrayList<Goods>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Goods goods=new Goods();
				
				goods.setId(rs.getInt("��Ʒ���"));
				goods.setManufact(rs.getString("��������"));
				goods.setName(rs.getString("��Ʒ��"));
				goods.setModel(rs.getString("�ͺ�"));
				goods.setUnivalent(rs.getInt("����"));
				goods.setAmount(rs.getInt("����"));
				goods.setTotalmoney(rs.getInt("�ܽ��"));
				goods.setYear(rs.getInt("������"));
				goods.setMonth(rs.getInt("������"));
				goods.setDay(rs.getInt("������"));
				goods.setEmployeeid(rs.getInt("ҵ��Ա���"));
				
				
				list.add(goods);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Sell> queryAllSell(){
		String sql="Select * from Sell ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Sell> list=new ArrayList<Sell>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Sell sell=new Sell();
				
				sell.setId(rs.getInt("��Ʒ���"));
				sell.setManufact(rs.getString("��������"));
				sell.setName(rs.getString("��Ʒ��"));
				sell.setModel(rs.getString("�ͺ�"));
				sell.setUnivalent(rs.getInt("����"));
				sell.setAmount(rs.getInt("����"));
				sell.setTotalmoney(rs.getInt("�ܽ��"));
				sell.setYear(rs.getInt("������"));
				sell.setMonth(rs.getInt("������"));
				sell.setDay(rs.getInt("������"));
				sell.setEmployeeid(rs.getInt("ҵ��Ա���"));
				
				
				list.add(sell);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Retreat> queryAllRetreat(){
		String sql="Select * from Retreat ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Retreat> list=new ArrayList<Retreat>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Retreat retreat=new Retreat();
				
				retreat.setId(rs.getInt("�˻����"));
				retreat.setManufact(rs.getString("����"));
				retreat.setName(rs.getString("��Ʒ��"));
				retreat.setModel(rs.getString("�ͺ�"));
				retreat.setUnivalent(rs.getInt("����"));
				retreat.setAmount(rs.getInt("����"));
				retreat.setTotalmoney(rs.getInt("�ܽ��"));
				retreat.setYear(rs.getInt("�˻���"));
				retreat.setMonth(rs.getInt("�˻���"));
				retreat.setDay(rs.getInt("�˻���"));
				retreat.setEmployeeid(rs.getInt("ҵ��Ա���"));
				
				
				list.add(retreat);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Employee> queryAllEmployee(){
		String sql="Select * from Employee ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Employee> list=new ArrayList<Employee>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Employee employee=new Employee();
				
				employee.setId(rs.getInt("Ա�����"));
				employee.setName(rs.getString("Ա������"));
				employee.setTele(Integer.parseInt(rs.getString("Ա���绰")));
				employee.setAddress(rs.getString("Ա����ַ"));
				
				
				list.add(employee);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Manufact> queryAllManufact(){
		String sql="Select * from manufacturer ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Manufact> list=new ArrayList<Manufact>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Manufact manufact=new Manufact();
				
				manufact.setId(rs.getInt("���̱��"));
				manufact.setName(rs.getString("��������"));
				manufact.setRepresent(rs.getString("���˴���"));
				manufact.setTele(rs.getString("�绰"));
				manufact.setAddress(rs.getString("���̵�ַ"));
				
				
				list.add(manufact);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Remains> queryAllRemains(){
		String sql="SELECT * "
					+"FROM goods "
					+"WHERE goods.��Ʒ��� NOT IN ("
					+"		SELECT \"��Ʒ���\" "
					+"		FROM sell "
					+"		WHERE sell.��Ʒ��� NOT IN ("
					+"				SELECT \"�˻����\" "
					+"				FROM retreat"
					+"		)"
					+");";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Remains> list=new ArrayList<Remains>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Remains remain=new Remains();
				
				remain.setId(rs.getInt("��Ʒ���"));
				remain.setManufact(rs.getString("��������"));
				remain.setName(rs.getString("��Ʒ��"));
				remain.setModel(rs.getString("�ͺ�"));
				remain.setUnivalent(rs.getInt("����"));
				remain.setAmount(rs.getInt("����"));
				remain.setTotalmoney(rs.getInt("�ܽ��"));
				remain.setYear(rs.getInt("������"));
				remain.setMonth(rs.getInt("������"));
				remain.setDay(rs.getInt("������"));
				remain.setEmployeeid(rs.getInt("ҵ��Ա���"));
				
				
				list.add(remain);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	} 
	
	public static int numberOfRemains(){
		String sql="SELECT * "
					+"FROM goods "
					+"WHERE goods.��Ʒ��� NOT IN ("
					+"		SELECT \"��Ʒ���\" "
					+"		FROM sell "
					+"		WHERE sell.��Ʒ��� NOT IN ("
					+"				SELECT \"�˻����\" "
					+"				FROM retreat"
					+"		)"
					+");";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		int result=0;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	} 
	
	public static int numberOfGoods(){
		int result=0;
		String sql="Select * from Goods ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfGoods(Time time){
		int result=0;
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String sql=null;
		switch(time){
			case DAY:
				sql="Select * "
					+"From Goods "
					+"Where \"������\"="+year+" And \"������\"="+month+" And \"������\"="+date+" ";
				break;
			/* unimplement
			 * case WEEK:
				sql="Select * "
					+"From Goods "
					+"";
				break;*/
			case MONTH:
				sql="Select * "
					+"From Goods "
					+"Where \"������\"="+year+" And \"������\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From Goods "
					+"Where \"������\"=2016 And (\"������\"="+(quarter*3-2)
					+" or \"������\"="+(quarter*3-1)+" or \"������\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From Goods "
					+"Where \"������\"="+year;
				break;		
		}

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfSell(){
		int result=0;
		String sql="Select * from Sell ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfSellOfSameName(String name){
		int result=0;
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"��Ʒ��\"=\""+name+"\" ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfSellOfSameNameNModel(String name,String model){
		int result=0;
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"��Ʒ��\"=\""+name+"\" and \"�ͺ�\"=\""+model+"\" ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfSellOfSameModel(String model){
		int result=0;
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"�ͺ�\"=\""+model+"\" ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfSell(Time time){
		int result=0;
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String sql=null;
		switch(time){
			case DAY:
				sql="Select * "
					+"From SELL "
					+"Where \"������\"="+year+" And \"������\"="+month+" And \"������\"="+date+" ";
				break;
			/* unimplement
			 * case WEEK:
				sql="Select * "
					+"From Goods "
					+"";
				break;*/
			case MONTH:
				sql="Select * "
					+"From SELL "
					+"Where \"������\"="+year+" And \"������\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From SELL "
					+"Where \"������\"=2016 And (\"������\"="+(quarter*3-2)
					+" or \"������\"="+(quarter*3-1)+" or \"������\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From SELL "
					+"Where \"������\"="+year;
				break;		
		}

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfRetreat(){
		int result=0;
		String sql="Select * from Retreat ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfRetreat(Time time){
		int result=0;
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String sql=null;
		switch(time){
			case DAY:
				sql="Select * "
					+"From RETREAT "
					+"Where \"�˻���\"="+year+" And \"�˻���\"="+month+" And \"�˻���\"="+date+" ";
				break;
			/* unimplement
			 * case WEEK:
				sql="Select * "
					+"From Goods "
					+"";
				break;*/
			case MONTH:
				sql="Select * "
					+"From RETREAT "
					+"Where \"�˻���\"="+year+" And \"�˻���\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From RETREAT "
					+"Where \"�˻���\"=2016 And (\"�˻���\"="+(quarter*3-2)
					+" or \"�˻���\"="+(quarter*3-1)+" or \"�˻���\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From RETREAT "
					+"Where \"�˻���\"="+year;
				break;		
		}

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){result++;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfEmployee(){
		int result=0;
		String sql="SELECT count(\"Ա�����\")" 
				+"FROM employee";
		

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			result=Integer.parseInt(rs.getString("count(\"Ա�����\")"));
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfManufact(){
		int result=0;
		String sql="SELECT count(\"���̱��\")" 
				+"FROM manufacturer";
		

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			result=Integer.parseInt(rs.getString("count(\"���̱��\")"));
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static List<Employee> queryEmployeeById(int id){
		String sql="SELECT * "
					+"FROM EMPLOYEE "
					+"WHERE \"Ա�����\"="+id+" ";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		List<Employee> list=new ArrayList<Employee>();
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			while(rs.next()){
				Employee employee=new Employee();
				
				employee.setId(rs.getInt("Ա�����"));
				employee.setName(rs.getString("Ա������"));
				employee.setTele(Integer.parseInt(rs.getString("Ա���绰")));
				employee.setAddress(rs.getString("Ա����ַ"));
				
				
				list.add(employee);
			}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
	
	public static List<Sell> querySellByNameNModel(String name,String model){
		String sql="SELECT * "
				+"FROM sell "
				+"WHERE \"��Ʒ��\"=\""+name+"\" and \"�ͺ�\"=\""+model+"\" ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
	
		List<Sell> list=new ArrayList<Sell>();
	
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
		
			while(rs.next()){
				Sell sell=new Sell();
			
				sell.setId(rs.getInt("��Ʒ���"));
				sell.setManufact(rs.getString("��������"));
				sell.setName(rs.getString("��Ʒ��"));
				sell.setModel(rs.getString("�ͺ�"));
				sell.setUnivalent(rs.getInt("����"));
				sell.setAmount(rs.getInt("����"));
				sell.setTotalmoney(rs.getInt("�ܽ��"));
				sell.setYear(rs.getInt("������"));
				sell.setMonth(rs.getInt("������"));
				sell.setDay(rs.getInt("������"));
				sell.setEmployeeid(rs.getInt("ҵ��Ա���"));
						
				list.add(sell);
			}
			}catch (Exception e){
			e.printStackTrace();
		}finally{
			DataBase.freeDb(rs, conn,pstat);
		}
		return list;
	}
}

