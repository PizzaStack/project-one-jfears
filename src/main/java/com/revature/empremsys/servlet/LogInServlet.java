package com.revature.empremsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.empremsys.daos.*;

public class LogInServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private DAOEmployee daoEmp = new DAOEmployee();
	private DAOManager daoMan = new DAOManager();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		if(daoEmp.checklogin(username, password))
		response.sendRedirect("views/employeehome.html");
		else if(daoMan.checklogin(username, password))
		response.sendRedirect("views/managerhome.html");
		
	}
	
}
