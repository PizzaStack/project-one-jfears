package com.revature.empremsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.revature.empremsys.daos.*;
import org.json.JSONArray;


public class GetResolvedMan extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOManager daoMan = new DAOManager();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
		JSONArray requests = daoMan.getResolved();
		PrintWriter out = response.getWriter();
		out.println(requests);
		}
	}

}
