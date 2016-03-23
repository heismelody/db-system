package dbsystem;

import java.sql.*;

public class DataBase 
{
	static String usrname="root";
	static String password="root";
	static{
		try{//����SQLite��JDBC			
        	
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
    	   
          	//�û����userdb,Ա��������Ϣ���employee,����������Ϣ���manufacturer,
        	//�ִ����Ϣ���goods,������Ʒ��Ϣ���sell,�˻���Ϣ���retreat
        	String usersql,empsql,facsql,goodsql,sellsql,retreatsql;
        	
        	usersql=                //����ϵͳ�û����userdb
        			"create table if not exists  userdb "
        			+ "		(�û���� int IDENTITY (1, 1) "
        			+ "					NOT NULL CONSTRAINT PK_userdb PRIMARY KEY,"
        			+ "		�û��� nvarchar(10) ,"
        			+ "		����    nvarchar(10) )";
        	empsql=                 //����Ա��������Ϣ���employee
        			"create table if not exists  employee "
        			+ "		(Ա����� int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_employee PRIMARY KEY,"
        			+ "		Ա������ nvarchar (10),"
        			+ "		Ա���绰 nvarchar (20),"
        			+ "		Ա����ַ nvarchar (100))";
        	facsql=                  //��������������Ϣ���manufacturer
        			"create table if not exists  manufacturer "
        			+ "		(���̱�� int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_manufacture PRIMARY KEY,"
        			+ "		�������� nvarchar (20) "
        			+ "					CONSTRAINT IX_manufacturer_1 UNIQUE,"
        			+ "		���˴��� nvarchar (10) ,"
        			+ "		�绰  nvarchar (20)  ,"
        			+ "		���̵�ַ nvarchar (100) )";
        	goodsql=                    //�����ִ����Ϣ���goods
        			"create table if not exists  goods "
        			+ "		(��Ʒ��� int IDENTITY (1, 1) NOT NULL"
        			+ "					CONSTRAINT PK_goods PRIMARY KEY ,"
        			+ "		�������� nvarchar (20)"
        			+ "					CONSTRAINT FK_goods_manufacturer REFERENCES manufacturer(��������),"
        			+ "		��Ʒ�� nvarchar (20),"
        			+ "		�ͺ� nvarchar (20),"
        			+ "		���� money NULL 	CONSTRAINT DF_goods_���� DEFAULT (0),"
        			+ "		���� numeric (10, 0) NULL CONSTRAINT DF_goods_���� DEFAULT (0),"
        			+ "		�ܽ�� money NULL ,"
        			+ "		������ smallint NULL CONSTRAINT DF_goods_������ DEFAULT (year(getdate())),"
        			+ "		������ smallint NULL CONSTRAINT DF_goods_������ DEFAULT (month(getdate())),"
        			+ "		������ smallint NULL CONSTRAINT DF_goods_������ DEFAULT (day(getdate())),"
        			+ "		ҵ��Ա��� int NULL "
        			+ "					CONSTRAINT FK_goods_employee REFERENCES employee (Ա�����))";
        	sellsql=                   //����������Ʒ��Ϣ���sell
        			"create table if not exists  sell ("
        			+ "		��Ʒ��� int IDENTITY (1, 1) NOT NULL "
        			+ "					CONSTRAINT PK_sell PRIMARY KEY,"
        			+ "		�������� nvarchar (20)"
        			+ "					CONSTRAINT FK_sell_manufacturer REFERENCES manufacturer(��������),"
        			+ "		��Ʒ�� nvarchar (50) ,"
        			+ "		�ͺ� nvarchar (50),"
        			+ "		���� money NULL CONSTRAINT DF_sell_���� DEFAULT (0),"
        			+ "		���� int NULL CONSTRAINT DF_sell_���� DEFAULT (0),"
        			+ "		�ܽ�� money NULL CONSTRAINT DF_sell_�ܽ�� DEFAULT (0),"
        			+ "		������ smallint NULL CONSTRAINT DF_sell_������ DEFAULT (year(getdate())),"
        			+ "		������ smallint NULL CONSTRAINT DF_sell_������ DEFAULT (month(getdate())),"
        			+ "		������ smallint NULL CONSTRAINT DF_sell_������ DEFAULT (day(getdate())),"
        			+ "		ҵ��Ա��� int NULL "
        			+ "					CONSTRAINT FK_sell_employee REFERENCES employee (Ա�����))";
        	retreatsql=            //�����˻���Ϣ���retreat
        			"create table if not exists  retreat "
        			+ "		(�˻���� int IDENTITY (1, 1) NOT NULL"
        			+ "					CONSTRAINT PK_retreat PRIMARY KEY,"
        			+ "		���� nvarchar (20)"
        			+ "					CONSTRAINT FK_retreat_manufacturer REFERENCES manufacturer(��������),"
        			+ "		��Ʒ�� nvarchar (20),"
        			+ "		�ͺ� nvarchar (20) ,"
        			+ "		���� money NULL CONSTRAINT DF_retreat_���� DEFAULT (0),"
        			+ "		���� int NULL CONSTRAINT DF_retreat_���� DEFAULT (0),"
        			+ "		�ܽ�� money NULL CONSTRAINT DF_retreat_�ܽ�� DEFAULT (0),"
        			+ "		�˻��� smallint NULL ,"
        			+ "		�˻��� smallint NULL ,"
        			+ "		�˻��� smallint NULL ,"
        			+ "		ҵ��Ա��� int NULL "
        			+ "					CONSTRAINT FK_retreat_employee REFERENCES employee (Ա�����))";
        	
			conn=DriverManager.getConnection("jdbc:sqlite:sellsystem.db");
        	stat=conn.createStatement();
        	stat.executeUpdate(usersql);
        	stat.executeUpdate(empsql);
        	stat.executeUpdate(goodsql);
        	stat.executeUpdate(facsql);
        	stat.executeUpdate(sellsql); 
        	stat.executeUpdate(retreatsql);
        	
        	//�������ݿ������ 
   
        	
        	//ResultSet rs = stat.executeQuery("select * from usrdb;"); //��ѯ���� 
        	//while (rs.next()) { //����ѯ�������ݴ�ӡ����
        	//	System.out.print("name = " + rs.getString("name") + " "); //������һ
        	//	System.out.println("salary = " + rs.getString("salary")); //�����Զ�
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
