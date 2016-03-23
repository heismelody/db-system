package dbsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import login.Good;
import login.Manufact;

public class Update {
	
	public static boolean deleteManufactById(int id){
		boolean result=false;
		String sql="DELETE FROM manufacturer "
					+"WHERE \"厂商编号\"=\""+id+"\"";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
			
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			int colume=pstat.executeUpdate();
			if(colume > 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
			}
			return result;
	}
	
	public static boolean deleteEmployeeById(int id){
		boolean result=false;
		String sql="DELETE FROM employee "
					+"WHERE \"员工编号\"=\""+id+"\"";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
			
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			int colume=pstat.executeUpdate();
			if(colume > 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
			}
			return result;
	}
	
	public static boolean insertNamePw(int id,String name,String password){
		boolean result=false;
		String sql="INSERT INTO userdb "
					+"VALUES (?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		if(Query.queryIdExist(id)){
			System.out.println("id constranint");
			return false;
		}
		else if(Query.queryNameExist(name)){
			System.out.println("name constranint");
			return false;
		}else{
			try{
		
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			pstat.setString(2,name);
			pstat.setString(3,password);
			int colume=pstat.executeUpdate();
			if(colume > 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
			}
			return result;
		}		
	}
	
	public static boolean changePwByName(String name,String password){
		boolean result=false;
		String sql="UPDATE userdb "
					+"SET \"密码\"=? "
					+"WHERE \"用户名\"=\""+name+"\"";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
			
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, password);
			int colume=pstat.executeUpdate();
			if(colume > 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
			}
			return result;
		}
	
	public static boolean updateEmployee(int id,String name,String tele,String address){
		boolean result=false;
		String sql="UPDATE employee "
					+"SET \"员工姓名\" = ?,"
					+"\"员工电话\" = ?,"
					+"\"员工地址\" = ? "
					+"WHERE \"员工编号\" = \""+id+"\"";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, tele);
			pstat.setString(3, address);
			int colume=pstat.executeUpdate();
			if(colume != 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static boolean insertGood(Good good){
		boolean result=false;
		String sql="INSERT INTO "+good.getClass().getSimpleName()+" "
					+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, good.getId());
			pstat.setString(2, good.getManufact());
			pstat.setString(3, good.getName());
			pstat.setString(4, good.getModel());
			pstat.setInt(5, good.getUnivalent());
			pstat.setInt(6, good.getAmount());
			pstat.setInt(7, good.getTotalmoney());
			pstat.setInt(8, good.getYear());
			pstat.setInt(9, good.getMonth());
			pstat.setInt(10, good.getDay());
			pstat.setInt(11, good.getEmployeeid());
			int colume=pstat.executeUpdate();
			if(colume != 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
	}
	
	public static boolean insertManufacter(Manufact manu){
		boolean result = false;
		
		String sql="INSERT INTO manufacturer "
				+"VALUES (?,?,?,?,?)";
	
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, manu.getId());
			pstat.setString(2,manu.getName());
			pstat.setString(3,manu.getRepresent());
			pstat.setString(4,manu.getTele());
			pstat.setString(5,manu.getAddress());
			int colume=pstat.executeUpdate();
			if(colume > 0){result=true;}
			}catch (Exception e){
			e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;		
	}

	public static boolean updateManufact(int id, String name,
			String represent, String tele, String address) {
		boolean result=false;
		String sql="UPDATE manufacturer "
					+"SET \"厂商名称\" = ?,"
					+"\"法人代表\" = ?,"
					+"\"电话\" = ?, "
					+"\"厂商地址\" = ? "
					+"WHERE \"厂商编号\" = \""+id+"\"";
		
		Connection conn=null;
		PreparedStatement pstat=null;
		ResultSet rs=null;
		try{
			conn=DataBase.getConnection();
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, represent);
			pstat.setString(3, tele);
			pstat.setString(4, address);
			int colume=pstat.executeUpdate();
			if(colume != 0){result=true;}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				DataBase.freeDb(rs, conn,pstat);
		}
		return result;
		
	}
}
