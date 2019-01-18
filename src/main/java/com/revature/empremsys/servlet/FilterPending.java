package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.revature.empremsys.daos.*;

public class FilterPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOEmployee emp = new DAOEmployee();   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			String empid = request.getParameter("filterfield");
			int empidnum = Integer.parseInt(empid);
			JSONArray filtered = emp.getAll(empidnum);
			response.setContentType("text/json");
			PrintWriter out = response.getWriter();
			out.print(filtered);
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		if(session != null) {
//			String empid = request.getParameter("filterfield");
//			System.out.println(empid);
//			int empidnum = Integer.parseInt(empid);
//			JSONArray filtered = emp.getAll(empidnum);
//			System.out.println(filtered);
//			response.setContentType("text/json");
//			PrintWriter out = response.getWriter();
//			out.print(filtered);
			
			
//		}
	}

}
