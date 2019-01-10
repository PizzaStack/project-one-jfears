package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.empremsys.daos.DAOEmployee;

public class FillInPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DAOEmployee daoEmp = new DAOEmployee();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String username = (String) session.getAttribute("username");
			String password = daoEmp.getPass(username);
			PrintWriter out = response.getWriter();
			out.write(password);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
