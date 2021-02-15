package com.vishnu.web.model;

public class Notes {
	
	private int noteId;
	private int bookId;
	private String noteName;
	private String description;
	private String startDate;
	private String endDate;
	private String reminderDate;
	private String tag;
	private String status;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReminderDate() {
		return reminderDate;
	}
	public void setReminderDate(String reminderDate) {
		this.reminderDate = reminderDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@Override
	public String toString() {
		return "Notes [noteId=" + noteId + ", bookId=" + bookId + ", noteName=" + noteName + ", description="
				+ description + ", startDate=" + startDate + ", endDate=" + endDate + ", reminderDate=" + reminderDate
				+ ", tag=" + tag + ", status=" + status + "]";
	}
	
}
