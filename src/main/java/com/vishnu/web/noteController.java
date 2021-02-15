package com.vishnu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vishnu.web.Dao.NotesDao;
import com.vishnu.web.model.User;

/**
 * Servlet implementation class noteController
 */
public class noteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		NotesDao notesDao = new NotesDao();
		List notes = new ArrayList();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String action = request.getParameter("action");
		String from = (String) session.getAttribute("from");
		String optionId = String.valueOf(user.getID());;
		String option = "uid";
		
		System.out.println("from is ======" + from);
		System.out.println(request.getParameter("uid") + "          "+"USER".equals(from));
		
		if(request.getParameter("uid") != null || "USER".equals(from)) {
			System.out.println("Inside user If loop ***********");
			session.setAttribute("nid", null);
			optionId = String.valueOf(user.getID());
			option = "uid";
			session.setAttribute("from", "USER");
		}
		from = (String) session.getAttribute("from");
		if("delete".equals(action)) {
			String itemId = request.getParameter("itemId");
			notesDao.deleteNote(itemId);
			
		}
		
		if("TODAY'S LIST".equals(from)) {
			session.setAttribute("nid", null);
			System.out.println("Inside todays If loop ***********");
			RequestDispatcher rd = request.getRequestDispatcher("dashboardController");
			rd.forward(request, response);
			return;
		}
	    if("NOTEBOOKS".equals(from))	
		{
	    	System.out.println("Inside notebook If loop ***********");
			session.setAttribute("from", "NOTEBOOKS");
			if(request.getParameter("name") != null) {
				session.setAttribute("nid", request.getParameter("nid"));
				session.setAttribute("name", request.getParameter("name"));
			}
				optionId = (String) session.getAttribute("nid");
				option = "nid";
		}
		
		System.out.println("optionId      " + optionId + "    option    "+ option);
		notes = notesDao.getAllNotes(optionId, option);
		request.getSession().setAttribute("notes", notes);
		System.out.println(notes);
		RequestDispatcher rd = request.getRequestDispatcher("allNotes.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		NotesDao notesdao = new NotesDao();
		String action = request.getParameter("action");
		System.out.println(action);
		User user = (User) request.getSession().getAttribute("user");
		String uid = String.valueOf(user.getID());
		String noteName = request.getParameter("noteName");
		String status = request.getParameter("statusName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String reminderDate = request.getParameter("remainderDate");
		String tag = request.getParameter("tagName");
		String description = request.getParameter("noteDescription");
		
		
		if("edit".equals(action)){
			String noteId = request.getParameter("noteId");
			System.out.println(noteId);
			notesdao.updateNote(uid, noteName, status, startDate, endDate, reminderDate, tag, description, noteId);
		}
		
		if("create".equals(action))
		{
			String nid = (String) request.getSession().getAttribute("nid");
			notesdao.createNote(nid, uid, noteName, status, startDate, endDate, reminderDate, tag, description);
			System.out.println(nid);
		}
		doGet(request, response);
		
	}
	
}
