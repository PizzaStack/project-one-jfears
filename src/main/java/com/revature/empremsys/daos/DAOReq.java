package com.revature.empremsys.daos;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;

import com.revature.empremsys.entity.Employee;

public class DAOReq {
	protected DAOParent dao = new DAOParent();
	
	public JSONArray empPendingRequest(Employee employee) {
		String sql = "select * from requests where empid=" + employee.getId() + " and requeststatus=\'Pending\'";
		JSONArray requestsPend = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("rcpid", rs.getInt("rcpid"));
				obj.put("reqid", rs.getInt("requestid"));
				obj.put("title",rs.getString("requesttitle"));
				obj.put("details",rs.getString("requestdetails"));
				obj.put("status",rs.getString("requeststatus"));
				requestsPend.put(obj);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return requestsPend;
	}

	public JSONArray empResolvedRequest(Employee employee) {
		String sql = "select * from requests where empid=" + employee.getId() + " and requeststatus!=\'Pending\'";
		JSONArray requestsRes = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
						
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("empid", rs.getInt("empid"));
				obj.put("manid", rs.getInt("manid"));
				obj.put("rcpid", rs.getInt("rcpid"));
				obj.put("reqid", rs.getInt("requestid"));
				obj.put("title",rs.getString("requesttitle"));
				obj.put("details",rs.getString("requestdetails"));
				obj.put("status",rs.getString("requeststatus"));
				requestsRes.put(obj);
				}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return requestsRes;
	}

	public JSONArray getPending() {
		String sql = "select * from requests where requeststatus=\'Pending\'";
		JSONArray requestsRes = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
						
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("empid", rs.getInt("empid"));
				obj.put("manid", rs.getInt("manid"));
				obj.put("rcpid", rs.getInt("rcpid"));
				obj.put("reqid", rs.getInt("requestid"));
				obj.put("title",rs.getString("requesttitle"));
				obj.put("details",rs.getString("requestdetails"));
				obj.put("status",rs.getString("requeststatus"));
				requestsRes.put(obj);
				}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return requestsRes;
	}
	
	public JSONArray getResolved() {
		String sql = "select * from requests where  requeststatus!=\'Pending\'";
		JSONArray requestsRes = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
						
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("empid", rs.getInt("empid"));
				obj.put("manid", rs.getInt("manid"));
				obj.put("rcpid", rs.getInt("rcpid"));
				obj.put("reqid", rs.getInt("requestid"));
				obj.put("title",rs.getString("requesttitle"));
				obj.put("details",rs.getString("requestdetails"));
				obj.put("status",rs.getString("requeststatus"));
				requestsRes.put(obj);
				}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return requestsRes;
	}
	
	public JSONArray getAllByEmp(Employee employee) {
		String sql = "select * from requests where  empid=" + employee.getId();
		JSONArray reqs = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
						
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("empid", rs.getInt("empid"));
				obj.put("manid", rs.getInt("manid"));
				obj.put("rcpid", rs.getInt("rcpid"));
				obj.put("reqid", rs.getInt("requestid"));
				obj.put("title",rs.getString("requesttitle"));
				obj.put("details",rs.getString("requestdetails"));
				obj.put("status",rs.getString("requeststatus"));
				reqs.put(obj);
				}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return reqs;
	}

	public void submitRequest(Employee employee, String requesttitle, String requestdetails) {
		Random rand = new Random();
		int reqid = rand.nextInt(10)+1;
		int empid = employee.getId();
		int manid = 0;
		String title = requesttitle;
		String details = requestdetails;
		String status = "Pending";
		String sql = "insert into requests " + 
				"(requestid, empid, manid, requesttitle, requestdetails, requeststatus)" + 
				"values(" + reqid +", " + empid + ", " + manid + ", \'" + title + "\', \'" 
				+ details + "\', \'" + status + "\')";
		try {
			Statement statement =  dao.connection.createStatement();
			statement.execute(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
