package com.vishnu.web;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vishnu.web.Dao.NotebooksDao;
import com.vishnu.web.model.NoteBooks;
import com.vishnu.web.model.User;

/**
 * Servlet implementation class noteBooksController
 */


public class noteBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.getSession().setAttribute("from","NOTEBOOKS");
		String nid = request.getParameter("bookId");
		NotebooksDao booksDao = new NotebooksDao();
		booksDao.deleteNoteBooks(nid);
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int uid = user.getID();
		List booksList = new ArrayList();
		booksList = booksDao.getNotebooks(uid);
		request.getSession().setAttribute("books", booksList);
		RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
		rd.forward(request, response);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("reached to the noteBookController");
		String action = request.getParameter("ACTION");
		System.out.println("Action : "+action);
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		int uid = user.getID();
		
		
		NotebooksDao booksDao = new NotebooksDao();
		
		List booksList = new ArrayList();
		
		if("addNoteBook".equals(action)) {
			System.out.println("inside notebook controller addnotebook");
			String noteBookName = request.getParameter("noteBookName");
			booksDao.createNotebooks(uid, noteBookName);
			//booksList = booksDao.getNotebooks(uid);
		}
		
		if("editNoteBook".equals(action))
		{
			String noteBookName = request.getParameter("noteBookName");
			String bookId = request.getParameter("noteBookId");
			booksDao.updateNotebooks(bookId, String.valueOf(uid), noteBookName);
		}
		
			System.out.println("inside else");
			session.setAttribute("from","NOTEBOOKS");
			booksList = booksDao.getNotebooks(uid);
			request.getSession().setAttribute("books", booksList);
			RequestDispatcher rd = request.getRequestDispatcher("noteBooks.jsp");
			rd.forward(request, response);
		
		
	}

}
