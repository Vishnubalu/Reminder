package com.vishnu.web;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vishnu.web.Dao.UserDao;
import com.vishnu.web.model.User;

/**
 * Servlet implementation class editUserController
 */
public class editUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		RequestDispatcher rd = request.getRequestDispatcher("editUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int id = user.getID();
		String name = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobno = request.getParameter("mobileNumber");
		UserDao userdao = new UserDao();
	    boolean flag = userdao.updateUser(id, name, email, password, mobno);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	    
		
	}

}
