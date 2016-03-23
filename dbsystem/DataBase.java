package dbsystem;

import java.sql.*;

public class DataBase 
{
	static String usrname="root";
	static String password="root";
	static{
		try{//连接SQLite的JDBC			
        	
            Class.forName("org.sqlite.JDBC");
		}catch( Exception ex ){
			ex.printStackTrace();
			}
	}

	/**
	 * Connect to the database.
	 */
	public static Connection getConnection(){			
		Connection conn=null;
		
            	try {
					conn=DriverManager.getConnection("jdbc:sqlite:sellsystem.db");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return conn;
	}
	
	/**
	 * Create  the database.
	 * @return 
	 */
	public static void createDb(){
       try{
    	   Connection conn = null;
    	   Statement stat;
    	   ResultSet rs = null;
    	   
          	//用户表格userdb,员工基本信息表格employee,进货厂商信息表格manufacturer,
        	//现存货信息表格goods,已售商品信息表格sell,退货信息表格retreat
        	String usersql,empsql,facsql,goodsql,sellsql,retreatsql;
        	
        	usersql=                //创建系统用户表格userdb
        			"create table if not exists  userdb "
        			+ "		(用户编号 int IDENTITY (1, 1) "
        			+ "					NOT NULL CONSTRAINT PK_userdb PRIMARY KEY,"
        			+ "		用户名 nvarchar(10) ,"
        			+ "		密码    nvarchar(10) )";
        	empsql=                 //创建员工基本信息表格employee
        			"create table if not exists  employee "
        			+ "		(员工编号 int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_employee PRIMARY KEY,"
        			+ "		员工姓名 nvarchar (10),"
        			+ "		员工电话 nvarchar (20),"
        			+ "		员工地址 nvarchar (100))";
        	facsql=                  //创建进货厂商信息表格manufacturer
        			"create table if not exists  manufacturer "
        			+ "		(厂商编号 int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_manufacture PRIMARY KEY,"
        			+ "		厂商名称 nvarchar (20) "
        			+ "					CONSTRAINT IX_manufacturer_1 UNIQUE,"
        			+ "		法人代表 nvarchar (10) ,"
        			+ "		电话  nvarchar (20)  ,"
        			+ "		厂商地址 nvarchar (100) )";
        	goodsql=                    //创建现存货信息表格goods
        			"create table if not exists  goods "
        			+ "		(商品编号 int IDENTITY (1, 1) NOT NULL"
        			+ "					CONSTRAINT PK_goods PRIMARY KEY ,"
        			+ "		生产厂商 nvarchar (20)"
        			+ "					CONSTRAINT FK_goods_manufacturer REFERENCES manufacturer(厂商名称),"
        			+ "		商品名 nvarchar (20),"
        			+ "		型号 nvarchar (20),"
        			+ "		单价 money NULL 	CONSTRAINT DF_goods_单价 DEFAULT (0),"
        			+ "		数量 numeric (10, 0) NULL CONSTRAINT DF_goods_数量 DEFAULT (0),"
        			+ "		总金额 money NULL ,"
        			+ "		进货年 smallint NULL CONSTRAINT DF_goods_进货年 DEFAULT (year(getdate())),"
        			+ "		进货月 smallint NULL CONSTRAINT DF_goods_进货月 DEFAULT (month(getdate())),"
        			+ "		进货日 smallint NULL CONSTRAINT DF_goods_进货日 DEFAULT (day(getdate())),"
        			+ "		业务员编号 int NULL "
        			+ "					CONSTRAINT FK_goods_employee REFERENCES employee (员工编号))";
        	sellsql=                   //创建已售商品信息表格sell
        			"create table if not exists  sell ("
        			+ "		商品编号 int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_sell PRIMARY KEY,"
        			+ "		生产厂商 nvarchar (20)"
        			+ "					CONSTRAINT FK_sell_manufacturer REFERENCES manufacturer(厂商名称),"
        			+ "		商品名 nvarchar (50) ,"
        			+ "		型号 nvarchar (50),"
        			+ "		单价 money NULL CONSTRAINT DF_sell_单价 DEFAULT (0),"
        			+ "		数量 int NULL CONSTRAINT DF_sell_数量 DEFAULT (0),"
        			+ "		总金额 money NULL CONSTRAINT DF_sell_总金额 DEFAULT (0),"
        			+ "		销售年 smallint NULL CONSTRAINT DF_sell_销售年 DEFAULT (year(getdate())),"
        			+ "		销售月 smallint NULL CONSTRAINT DF_sell_销售月 DEFAULT (month(getdate())),"
        			+ "		销售日 smallint NULL CONSTRAINT DF_sell_销售日 DEFAULT (day(getdate())),"
        			+ "		业务员编号 int NULL "
        			+ "					CONSTRAINT FK_sell_employee REFERENCES employee (员工编号))";
        	retreatsql=            //创建退货信息表格retreat
        			"create table if not exists  retreat "
        			+ "		(退货编号 int IDENTITY (1, 1) NOT NULL"
        			+ "					CONSTRAINT PK_retreat PRIMARY KEY,"
        			+ "		厂商 nvarchar (20)"
        			+ "					CONSTRAINT FK_retreat_manufacturer REFERENCES manufacturer(厂商名称),"
        			+ "		商品名 nvarchar (20),"
        			+ "		型号 nvarchar (20) ,"
        			+ "		单价 money NULL CONSTRAINT DF_retreat_单价 DEFAULT (0),"
        			+ "		数量 int NULL CONSTRAINT DF_retreat_数量 DEFAULT (0),"
        			+ "		总金额 money NULL CONSTRAINT DF_retreat_总金额 DEFAULT (0),"
        			+ "		退货年 smallint NULL ,"
        			+ "		退货月 smallint NULL ,"
        			+ "		退货日 smallint NULL ,"
        			+ "		业务员编号 int NULL "
        			+ "					CONSTRAINT FK_retreat_employee REFERENCES employee (员工编号))";
        	
			conn=DriverManager.getConnection("jdbc:sqlite:sellsystem.db");
        	stat=conn.createStatement();
        	stat.executeUpdate(usersql);
        	stat.executeUpdate(empsql);
        	stat.executeUpdate(goodsql);
        	stat.executeUpdate(facsql);
        	stat.executeUpdate(sellsql); 
        	stat.executeUpdate(retreatsql);
        	
        	//结束数据库的连接 
   
        	
        	//ResultSet rs = stat.executeQuery("select * from usrdb;"); //查询数据 
        	//while (rs.next()) { //将查询到的数据打印出来
        	//	System.out.print("name = " + rs.getString("name") + " "); //列属性一
        	//	System.out.println("salary = " + rs.getString("salary")); //列属性二
         	//	}
         	//rs.close();
         	
        }
        catch( Exception ex ){
         ex.printStackTrace ( );
        }
	}
	
	public static void freeDb(ResultSet rs,Connection conn,PreparedStatement pstat){
			try{
				if(rs!=null)
					rs.close();
			}catch(SQLException e){
				System.out.println("close rs error");
				e.printStackTrace();
			}finally{
				try{
					if(pstat!=null)
						pstat.close();
				}catch(SQLException e){
					System.out.println("close pstat error");
					e.printStackTrace();
				}finally{
					try{
						if(conn!=null)
							conn.close();
					}catch(SQLException e){
						System.out.println("close conn error");
						e.printStackTrace();
					}
				}
			}
	}
}
