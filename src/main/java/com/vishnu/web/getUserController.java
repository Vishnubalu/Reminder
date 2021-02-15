package com.vishnu.web;

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
 * Servlet implementation class getUserController
 */

public class getUserController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		User user = userdao.getUser(email, password);
		
		if(user.getName() == null)
		{
			System.out.println(user.getName());
			request.setAttribute("error", "email/password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			
			rd.forward(request, response);
		}
		
		else {
			
			HttpSession session = request.getSession(true);
			request.getSession().setAttribute("user", user);
			System.out.println("inside getUser Controller");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/dashboardController?ACTION=show");
			rd.forward(request, response);
		}
		
		
	}

}
