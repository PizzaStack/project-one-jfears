package com.revature.empremsys.daos;

import java.sql.Statement;

import org.json.JSONArray;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOManager {
	protected DAOParent dao = new DAOParent();
	protected DAOReq req = new DAOReq();
	protected DAOEmployee emp = new DAOEmployee();
	
	public Boolean checklogin(String username, String password) {
		String sql = "select manpassword from manager where manusername=\'" + username + "\'" ;
		Boolean valid = false;
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				if(password.equals(rs.getString("manpassword")))
					valid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;
	}
	
	
	public JSONArray getPending() {
		JSONArray reqs = req.getPending();
		return reqs;
	}
	
	public JSONArray getResolved() {
		JSONArray reqs = req.getResolved();
		return reqs;
	}
	
	public JSONArray getEmployees() {
		JSONArray emps = emp.getAll();
		return emps;
	}
}
