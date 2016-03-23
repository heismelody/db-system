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
		String sql="SELECT \"密码\" "
					+"FROM userdb "
					+"WHERE \"用户名\"=?";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			rs=pstat.executeQuery();
			while(rs.next()){
				password=rs.getString("密码");
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
					+"WHERE \"用户编号\"=?";
					
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
				+"WHERE \"用户名\"=?";
				
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
				+"WHERE \"商品名\"=\""+name+"\" ";
	
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
			
				sell.setId(rs.getInt("商品编号"));
				sell.setManufact(rs.getString("生产厂商"));
				sell.setName(rs.getString("商品名"));
				sell.setModel(rs.getString("型号"));
				sell.setUnivalent(rs.getInt("单价"));
				sell.setAmount(rs.getInt("数量"));
				sell.setTotalmoney(rs.getInt("总金额"));
				sell.setYear(rs.getInt("销售年"));
				sell.setMonth(rs.getInt("销售月"));
				sell.setDay(rs.getInt("销售日"));
				sell.setEmployeeid(rs.getInt("业务员编号"));
						
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
				+"WHERE \"型号\"=\""+model+"\" ";
	
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
			
				sell.setId(rs.getInt("商品编号"));
				sell.setManufact(rs.getString("生产厂商"));
				sell.setName(rs.getString("商品名"));
				sell.setModel(rs.getString("型号"));
				sell.setUnivalent(rs.getInt("单价"));
				sell.setAmount(rs.getInt("数量"));
				sell.setTotalmoney(rs.getInt("总金额"));
				sell.setYear(rs.getInt("销售年"));
				sell.setMonth(rs.getInt("销售月"));
				sell.setDay(rs.getInt("销售日"));
				sell.setEmployeeid(rs.getInt("业务员编号"));
						
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
		
		String sql="SELECT sum(\"总金额\") "
					+"FROM SELL,EMPLOYEE "
					+"WHERE SELL.业务员编号 = EMPLOYEE.员工编号 AND SELL.业务员编号 = 1 ";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			result=rs.getInt("sum(\"总金额\")");
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
				
				goods.setId(rs.getInt("商品编号"));
				goods.setManufact(rs.getString("生产厂商"));
				goods.setName(rs.getString("商品名"));
				goods.setModel(rs.getString("型号"));
				goods.setUnivalent(rs.getInt("单价"));
				goods.setAmount(rs.getInt("数量"));
				goods.setTotalmoney(rs.getInt("总金额"));
				goods.setYear(rs.getInt("进货年"));
				goods.setMonth(rs.getInt("进货月"));
				goods.setDay(rs.getInt("进货日"));
				goods.setEmployeeid(rs.getInt("业务员编号"));
				
				
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
				
				sell.setId(rs.getInt("商品编号"));
				sell.setManufact(rs.getString("生产厂商"));
				sell.setName(rs.getString("商品名"));
				sell.setModel(rs.getString("型号"));
				sell.setUnivalent(rs.getInt("单价"));
				sell.setAmount(rs.getInt("数量"));
				sell.setTotalmoney(rs.getInt("总金额"));
				sell.setYear(rs.getInt("销售年"));
				sell.setMonth(rs.getInt("销售月"));
				sell.setDay(rs.getInt("销售日"));
				sell.setEmployeeid(rs.getInt("业务员编号"));
				
				
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
				
				retreat.setId(rs.getInt("退货编号"));
				retreat.setManufact(rs.getString("厂商"));
				retreat.setName(rs.getString("商品名"));
				retreat.setModel(rs.getString("型号"));
				retreat.setUnivalent(rs.getInt("单价"));
				retreat.setAmount(rs.getInt("数量"));
				retreat.setTotalmoney(rs.getInt("总金额"));
				retreat.setYear(rs.getInt("退货年"));
				retreat.setMonth(rs.getInt("退货月"));
				retreat.setDay(rs.getInt("退货日"));
				retreat.setEmployeeid(rs.getInt("业务员编号"));
				
				
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
				
				employee.setId(rs.getInt("员工编号"));
				employee.setName(rs.getString("员工姓名"));
				employee.setTele(Integer.parseInt(rs.getString("员工电话")));
				employee.setAddress(rs.getString("员工地址"));
				
				
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
				
				manufact.setId(rs.getInt("厂商编号"));
				manufact.setName(rs.getString("厂商名称"));
				manufact.setRepresent(rs.getString("法人代表"));
				manufact.setTele(rs.getString("电话"));
				manufact.setAddress(rs.getString("厂商地址"));
				
				
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
					+"WHERE goods.商品编号 NOT IN ("
					+"		SELECT \"商品编号\" "
					+"		FROM sell "
					+"		WHERE sell.商品编号 NOT IN ("
					+"				SELECT \"退货编号\" "
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
				
				remain.setId(rs.getInt("商品编号"));
				remain.setManufact(rs.getString("生产厂商"));
				remain.setName(rs.getString("商品名"));
				remain.setModel(rs.getString("型号"));
				remain.setUnivalent(rs.getInt("单价"));
				remain.setAmount(rs.getInt("数量"));
				remain.setTotalmoney(rs.getInt("总金额"));
				remain.setYear(rs.getInt("进货年"));
				remain.setMonth(rs.getInt("进货月"));
				remain.setDay(rs.getInt("进货日"));
				remain.setEmployeeid(rs.getInt("业务员编号"));
				
				
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
					+"WHERE goods.商品编号 NOT IN ("
					+"		SELECT \"商品编号\" "
					+"		FROM sell "
					+"		WHERE sell.商品编号 NOT IN ("
					+"				SELECT \"退货编号\" "
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
					+"Where \"进货年\"="+year+" And \"进货月\"="+month+" And \"进货日\"="+date+" ";
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
					+"Where \"进货年\"="+year+" And \"进货月\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From Goods "
					+"Where \"进货年\"=2016 And (\"进货月\"="+(quarter*3-2)
					+" or \"进货月\"="+(quarter*3-1)+" or \"进货月\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From Goods "
					+"Where \"进货年\"="+year;
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
				+"WHERE \"商品名\"=\""+name+"\" ";
		
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
				+"WHERE \"商品名\"=\""+name+"\" and \"型号\"=\""+model+"\" ";
		
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
				+"WHERE \"型号\"=\""+model+"\" ";
		
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
					+"Where \"销售年\"="+year+" And \"销售月\"="+month+" And \"销售日\"="+date+" ";
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
					+"Where \"销售年\"="+year+" And \"销售月\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From SELL "
					+"Where \"销售年\"=2016 And (\"销售月\"="+(quarter*3-2)
					+" or \"销售月\"="+(quarter*3-1)+" or \"销售月\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From SELL "
					+"Where \"销售年\"="+year;
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
					+"Where \"退货年\"="+year+" And \"退货月\"="+month+" And \"退货日\"="+date+" ";
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
					+"Where \"退货年\"="+year+" And \"退货月\"="+month+" ";
				break;
			case QUARTER:
				int quarter=(int)Math.ceil((double)month/3);
				sql="Select * "
					+"From RETREAT "
					+"Where \"退货年\"=2016 And (\"退货月\"="+(quarter*3-2)
					+" or \"退货月\"="+(quarter*3-1)+" or \"退货月\"="+(quarter*3)+") ";
				break;
			case YEAR:
				sql="Select * "
					+"From RETREAT "
					+"Where \"退货年\"="+year;
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
		String sql="SELECT count(\"员工编号\")" 
				+"FROM employee";
		

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			result=Integer.parseInt(rs.getString("count(\"员工编号\")"));
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static int numberOfManufact(){
		int result=0;
		String sql="SELECT count(\"厂商编号\")" 
				+"FROM manufacturer";
		

		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			rs=pstat.executeQuery();
			
			result=Integer.parseInt(rs.getString("count(\"厂商编号\")"));
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
					+"WHERE \"员工编号\"="+id+" ";
		
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
				
				employee.setId(rs.getInt("员工编号"));
				employee.setName(rs.getString("员工姓名"));
				employee.setTele(Integer.parseInt(rs.getString("员工电话")));
				employee.setAddress(rs.getString("员工地址"));
				
				
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
				+"WHERE \"商品名\"=\""+name+"\" and \"型号\"=\""+model+"\" ";
	
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
			
				sell.setId(rs.getInt("商品编号"));
				sell.setManufact(rs.getString("生产厂商"));
				sell.setName(rs.getString("商品名"));
				sell.setModel(rs.getString("型号"));
				sell.setUnivalent(rs.getInt("单价"));
				sell.setAmount(rs.getInt("数量"));
				sell.setTotalmoney(rs.getInt("总金额"));
				sell.setYear(rs.getInt("销售年"));
				sell.setMonth(rs.getInt("销售月"));
				sell.setDay(rs.getInt("销售日"));
				sell.setEmployeeid(rs.getInt("业务员编号"));
						
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

