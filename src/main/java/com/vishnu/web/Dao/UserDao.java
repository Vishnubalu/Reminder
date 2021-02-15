package com.vishnu.web.Dao;

import java.sql.*;

import com.vishnu.web.dbController;
import com.vishnu.web.model.User;

public class UserDao {

	dbController db = new dbController();
	
	public User getUser(String email, String password) {		
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email = '"+ email+ "'");
			if(rs.next()) {
				if(rs.getString("passWord").compareTo(password) == 0) {
					user.setEmail(rs.getString("email"));
					user.setPassWord(rs.getString("passWord"));
					user.setMobileNum(rs.getString("mobNo"));
					user.setName(rs.getString("userName"));
					user.setID(rs.getInt("ID"));
					System.out.println("inside DAO");
				}
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(user);
		return user;
	
	}

	public User setUser(String email, String password, String name, String mobno) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email = '"+ email+ "'");
			String query = " insert into users (userName, email, passWord, mobNo)"
			        + " values (?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			if(!rs.next()) {
				user.setName(name);
				preparedStmt.setString(1, name);
				preparedStmt.setString(2, email);
				preparedStmt.setString(3,  password);
				preparedStmt.setString(4,  mobno);
				preparedStmt.execute();
			    con.close();
			}		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(user);
		return user;
	}
	
	public boolean updateUser(int id, String username, String email, String password, String mobNo) {
		
		boolean flag = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			String query = "update users set userName=?, passWord=?, email=?, mobNo=? where ID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, mobNo);
			pstmt.setInt(5, id);
			pstmt.executeUpdate();
		}
		catch (Exception e){
			flag = false;
			System.out.println(e);
		}
		return flag;	
	}
}
