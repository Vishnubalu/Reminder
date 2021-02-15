package com.vishnu.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vishnu.web.Dao.NotebooksDao;
import com.vishnu.web.Dao.NotesDao;
import com.vishnu.web.model.User;

/**
 * Servlet implementation class dashboardController
 */
public class dashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NotesDao notesdao = new NotesDao();
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int uid = user.getID();
		session.setAttribute("nid", null);
		List combined = notesdao.getDailyNotes(uid);
		List dailyList = (List) combined.get(0);
		List reminderList = (List) combined.get(1);
		NotebooksDao booksDao = new NotebooksDao();
		session.setAttribute("dailyList", dailyList);
		request.getSession().setAttribute("notes", dailyList);
		session.setAttribute("reminderList", reminderList);
		List booksList = (List)booksDao.getNotebooks(uid);
		session.setAttribute("books", booksList);
		session.setAttribute("from", "TODAY'S LIST");
		System.out.println("daily list ______" + dailyList);
		System.out.println("reminder list -----------" + reminderList.size());
		RequestDispatcher rd = request.getRequestDispatcher("allNotes.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NotesDao notesdao = new NotesDao();
		HttpSession session = request.getSession();
		session.setAttribute("nid", null);
		User user = (User)session.getAttribute("user");
		int uid = user.getID();
		List combined = notesdao.getDailyNotes(uid);
		List dailyList = (List) combined.get(0);
		List reminderList = (List) combined.get(1);
		NotebooksDao booksDao = new NotebooksDao();
		session.setAttribute("dailyList", dailyList);
		request.getSession().setAttribute("notes", dailyList);
		session.setAttribute("reminderList", reminderList);
		List booksList = (List)booksDao.getNotebooks(uid);
		session.setAttribute("books", booksList);
		System.out.println("daily list ______" + dailyList);
		System.out.println("reminder list -----------" + reminderList.size());
		
		session.setAttribute("from", "TODAY'S LIST");
		
		RequestDispatcher rd = request.getRequestDispatcher("allNotes.jsp");
		rd.forward(request, response);
	}

}
