package com.vishnu.web.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vishnu.web.dbController;
import com.vishnu.web.model.NoteBooks;
import com.vishnu.web.model.Notes;

public class NotesDao {
	
	dbController db = new dbController();
	
	public List getAllNotes(String id, String option)
	{
		List list = new ArrayList();
		String query;
		if("nid".equals(option)) {
			query = "select * from notes where NID = '"+ id+"'";
		}
		else {
			query = "select * from notes where UID = '"+ id+"'";
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				
				Notes notes = new Notes();
				
				notes.setNoteId(rs.getInt("noteId"));
				notes.setBookId(rs.getInt("NID"));
				notes.setNoteName(rs.getString("noteName"));
				notes.setStatus(rs.getString("Status"));
				notes.setTag(rs.getString("tag"));
				notes.setDescription(rs.getString("Description"));
				notes.setStartDate(rs.getString("startDate"));
				notes.setEndDate(rs.getString("endDate"));
				notes.setReminderDate(rs.getString("reminderDate"));
				list.add(notes);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("inside getAllNotes ---" + list);
		return list;
	}
	
	
	public String getDateString(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date StrDate = new SimpleDateFormat("dd-mm-yyyy").parse(date);
		return sdf.format(StrDate);
		
	}
	
	public String getStringDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date StrDate = new SimpleDateFormat("yyyy-mm-dd").parse(date);
		return sdf.format(StrDate);
	}
		
		public List getDailyNotes(int uid)
		{
			List combinedList = new ArrayList();
			List dailyList = new ArrayList();
			List reminderList = new ArrayList();
			
			String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String query = "select * from notes where UID = '"+ uid +"'";
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					String startDate = rs.getString("startDate");
					String endDate = rs.getString("endDate");
					String reminderDate = rs.getString("reminderDate");
					
					Notes notes = new Notes();
					notes.setReminderDate(reminderDate);
					notes.setNoteId(rs.getInt("noteId"));
					notes.setBookId(rs.getInt("NID"));
					notes.setNoteName(rs.getString("noteName"));
					notes.setStatus(rs.getString("Status"));
					notes.setTag(rs.getString("tag"));
					notes.setDescription(rs.getString("Description"));
					notes.setStartDate(startDate);
					notes.setEndDate(endDate);
					if(getDateString(startDate).compareTo(today) <= 0  && getDateString(endDate).compareTo(today) >= 0)
					{
						dailyList.add(notes);
					}
					if(getDateString(reminderDate).compareTo(today) == 0)
					{
						reminderList.add(notes);
					}
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
			combinedList.add(dailyList);
			combinedList.add(reminderList);
			return combinedList;
			}
		
		public void updateNote(String uid, String noteName, String status, String startDate, String endDate, 
				String reminderDate, String tag, String description, String noteId)
		{
			
			try {
				
				startDate = getStringDate(startDate);
				endDate = getStringDate(endDate);
				reminderDate = getStringDate(reminderDate);
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
				Statement st = con.createStatement();
				String query = "update notes set noteName=?, Status=?, Description=?, startDate=?, endDate=?, reminderDate=?, tag=? where noteId=?";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1,  noteName);
				pstmt.setString(2, status);
				pstmt.setString(3, description);
				pstmt.setString(4, startDate);
				pstmt.setString(5, endDate);
				pstmt.setString(6, reminderDate);
				pstmt.setString(7, tag);
				pstmt.setString(8, noteId);
				pstmt.execute();
				con.close();
				
			}
			catch (Exception e){
				System.out.println(e);
			}
		}


		public void createNote(String nid, String uid, String noteName, String status, String startDate, String endDate,
				String reminderDate, String tag, String description) {			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
				Statement st = con.createStatement();
				String query = " insert into notes (NID,UID, noteName, Status, Description, startDate, endDate, reminderDate, tag)"
				        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				startDate = getStringDate(startDate);
				endDate = getStringDate(endDate);
				reminderDate = getStringDate(reminderDate);
				
				System.out.println("Create note date format chek *************** " + startDate);
				
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(3,  noteName);
				pstmt.setString(4, status);
				pstmt.setString(5, description);
				pstmt.setString(6, startDate);
				pstmt.setString(7, endDate);
				pstmt.setString(8, reminderDate);
				pstmt.setString(9, tag);
				pstmt.setString(1, nid);
				pstmt.setString(2,  uid);
				pstmt.execute();
			    
				String query2 = "update notebooks set totalNotes=? where NID=?";
				String query3 = "select totalNotes from notebooks where NID='"+nid+"'";
				ResultSet rs = st.executeQuery(query3);
				int totalNotes = 0;
				if(rs.next()) {
					totalNotes = rs.getInt("totalNotes");
				}
				pstmt = con.prepareStatement(query2);
				pstmt.setInt(1,  totalNotes+1);
				pstmt.setString(2, nid);
				pstmt.execute();
				
				con.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public void deleteNote(String noteId) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String query = "select NID from notes where noteId = '"+ noteId +"'";
				
				Connection con = DriverManager.getConnection(db.getUrl(), db.getUserName(), db.getPassWord());
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				String NID = null;
				if(rs.next()) {
					NID = rs.getString("NID");
				}
				
				String query2 = "update notebooks set totalNotes=? where NID=?";
				String query3 = "select totalNotes from notebooks where NID='"+NID+"'";
				rs = st.executeQuery(query3);
				int totalNotes = 0;
				if(rs.next()) {
					totalNotes = rs.getInt("totalNotes");
				}
				PreparedStatement pstmt = con.prepareStatement(query2);
				pstmt.setInt(1,  totalNotes-1);
				pstmt.setString(2, NID);
				pstmt.execute();
				
				query = "delete from notes where noteId= '" + noteId + "'";
				st.execute(query);
			}
			catch (Exception e){
				System.out.println(e);
			}
			
		}
}
