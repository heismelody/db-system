package login;

import dbsystem.DataBase;

public class User{
	
	private int identity;
	private String name;
	private String pw;
	
	public User(){		
	}

	public void changePW(User user,String pw){
		if(user==null){
		}
		else user.pw=pw;
		
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	
}
