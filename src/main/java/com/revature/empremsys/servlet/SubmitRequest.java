package com.revature.empremsys.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.empremsys.daos.*;

public class SubmitRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOEmployee emp = new DAOEmployee();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String username = (String) session.getAttribute("username");
			String requesttitle = request.getParameter("requesttitle");
			String requestdetails = request.getParameter("requestdtails");
			emp.submitRequest(username, requesttitle, requestdetails);
			response.sendRedirect("./pages/requestform.html");
		}
	}

}
