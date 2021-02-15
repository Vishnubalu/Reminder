package com.vishnu.web;

public class dbController {
	private String url = "jdbc:mysql://localhost:3306/virtusaNotifier";
	private String userName = "root";
	private String passWord = "Vishnu";
	public String getUrl() {
		return url;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
}
