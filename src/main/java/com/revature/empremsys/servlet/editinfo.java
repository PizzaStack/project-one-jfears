package com.revature.empremsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.empremsys.daos.DAOEmployee;
public class editinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOEmployee daoEmp = new DAOEmployee();   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String username = (String) session.getAttribute("username");
			String newfirstname = request.getParameter("newfirstname");
			String newlastname = request.getParameter("newlastname");
			String newusername = request.getParameter("newusername");
			session.setAttribute("username", newusername);
			String newpass = request.getParameter("newpass");
			 daoEmp.updateInfo(username, newfirstname, newlastname, newusername, newpass);
			 response.sendRedirect("./pages/viewinformation.html");
		}
		
		
	}

}
