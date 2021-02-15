package com.vishnu.web.model;

import java.util.Arrays;

public class NoteBooks {
	
	private String BookName;
	private int BookId;
	private int count;

	public String getBookName() {
		return BookName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	
	@Override
	public String toString() {
		return "NoteBooks [BookName=" + BookName + "]";
	}

}
