package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.revature.empremsys.daos.*;
public class GetResolved extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOReq req = new DAOReq();
    private DAOEmployee emp = new DAOEmployee();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			String username = (String) session.getAttribute("username");
			JSONArray requests = emp.getResolved(username);
			response.setContentType("text/json");
			PrintWriter out = response.getWriter();
			out.print(requests);
		}
	}

}
