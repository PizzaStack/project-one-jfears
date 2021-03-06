package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.revature.empremsys.daos.DAOEmployee;


public class GetPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
   DAOEmployee daoEmp = new DAOEmployee();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("username");
		JSONArray requests = daoEmp.getPending(username);
		PrintWriter out = response.getWriter();
		out.println(requests);

		
	}
}
