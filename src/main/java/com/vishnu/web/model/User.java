package com.vishnu.web.model;

public class User {
	
	private String userName;
	private String email;
	private String passWord;
	private String mobileNum;
	private int ID;
	
	
	public String getName() {
		return userName;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	
	@Override
	public String toString() {
		return "User [name=" + userName + ", email=" + email + ", passWord=" + passWord + ", mobileNum=" + mobileNum + "]";
	}
	
	
	
	
}
