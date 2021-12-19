package com.cugb.javaee.bean;

public class Users {
	int userid;
	String username;
	String pwd;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", pwd=" + pwd + "]";
	}
	
	
}
