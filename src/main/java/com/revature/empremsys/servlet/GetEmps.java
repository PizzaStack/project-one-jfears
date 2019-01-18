package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.revature.empremsys.daos.DAOManager;


public class GetEmps extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOManager man = new DAOManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			JSONArray emps = man.getEmployees();
			response.setContentType("text/json");;
			PrintWriter out = response.getWriter();
			out.print(emps);
		}
	}


}
