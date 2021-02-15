package com.vishnu.web.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vishnu.web.dbController;
import com.vishnu.web.model.NoteBooks;
import com.vishnu.web.model.User;

public class NotebooksDao {
	
	dbController db = new dbController();
	
	
	public List getNotebooks(int uid) {
		
		List list = new ArrayList();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from notebooks where UID = '"+ uid+"'" );
			while(rs.next()) {
				NoteBooks books = new NoteBooks();
				books.setBookId(rs.getInt("NID"));
				books.setBookName(rs.getString("bookName"));
				books.setCount(rs.getInt("totalNotes"));
				list.add(books);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(list);
		return list;
	}
	
	public void createNotebooks(int uid, String bookName)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			String query = " insert into notebooks (UID, bookName, totalNotes)"
			        + " values (?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setLong(1, uid);
			preparedStmt.setString(2, bookName);
			preparedStmt.setInt(3, 0);
			preparedStmt.execute();
		    con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateNotebooks(String nid, String uid, String bookName)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			String query = "update notebooks set bookName=? where NID=? and UID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1,  bookName);
			pstmt.setString(2, nid);
			pstmt.setString(3, uid);
			pstmt.execute();
			
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
	
	public void deleteNoteBooks(String nid)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			String query = "delete from notebooks where NID=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nid);
			pstmt.execute();
			
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
