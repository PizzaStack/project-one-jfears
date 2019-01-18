package com.revature.empremsys.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.revature.empremsys.entity.Employee;

public class DAOEmployee {
	protected DAOParent dao = new DAOParent();
	protected DAOReq req = new DAOReq();
	
	public Boolean checklogin(String username, String password) {
			String sql = "select emppassword from employee where empusername=\'" + username + "\'" ;
			Boolean valid = false;
			try {
				Statement statement = dao.connection.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				if(rs.next()) {
					if(password.equals(rs.getString("emppassword")))
						valid = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return valid;
	}
	
	public String getname(String username) {
		String sql = "select empfirstname, emplastname from employee where empusername=\'" + username +"\'";
		String name = "";
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				name = rs.getString("empfirstname");
				name = name + " ";
				name = name + rs.getString("emplastname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

	public String getPass(String username) {
		String sql = "select emppassword from employee where empusername=\'" + username +"\'";
		String password = "";
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next())
				password = rs.getString("emppassword");
		}
		catch(SQLException e) {
			e.printStackTrace();}
		return password;
	}
	
	public Employee makeEmployee(String username) {
		String sql = "select * from employee where empusername=\'" + username + "\'";
		Employee employee = new Employee();
		String firstName = "";
		String lastName = "";
		String password = "";
		int empId = 0;
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				firstName = rs.getString("empfirstname");
				lastName = rs.getString("emplastname");
				password = rs.getString("emppassword");
				empId = rs.getInt("empid");
				employee = new Employee(firstName, lastName, username, password, empId);
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return employee;
	}

	public JSONArray getPending(String username) {
		Employee employee = makeEmployee(username);
		JSONArray reqs = req.empPendingRequest(employee);
		return reqs;
	}
	
	public JSONArray getAll(int empid) {
		Employee employee = makeEmployee(empid);
		JSONArray reqs = req.getAllByEmp(employee);
		return reqs;
	}

	private Employee makeEmployee(int empid) {
		String sql = "select * from employee where empid=" + empid;
		Employee employee = new Employee();
		String firstName = "";
		String lastName = "";
		String password = "";
		String username = "";
		int empId = empid;
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				firstName = rs.getString("empfirstname");
				lastName = rs.getString("emplastname");
				password = rs.getString("emppassword");
				username = rs.getString("empusername");
				employee = new Employee(firstName, lastName, username, password, empId);
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return employee;
	}

	public JSONArray getResolved(String username) {
		Employee employee = makeEmployee(username);
		JSONArray reqs = req.empResolvedRequest(employee);
		return reqs;
	}
	

	public void updateInfo(String username, String newfirstname, String newlastname, String newusername, String newpass) {
		Employee employee = makeEmployee(username);
		Boolean posted = false;
		String sql = "update employee set empfirstname=\'" + newfirstname + "\', " +
				"emplastname=\'" + newlastname + "\', " +
				"empusername=\'" + newusername + "\', " +
				"emppassword=\'" + newpass + "\' where empid=" + employee.getId();
		try {
			Statement statement = dao.connection.createStatement();
			int rs = statement.executeUpdate(sql);
			if(rs == 0)
				posted = true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public JSONArray getAll() {
		String sql = "select * from employee";
		JSONArray emps = new JSONArray();
		
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("empid", rs.getInt("empid"));
				obj.put("empusername", rs.getString("empusername"));
				obj.put("empfirstname", rs.getString("empfirstname"));
				obj.put("emplastname", rs.getString("emplastname"));
				emps.put(obj);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}

	public void submitRequest(String username, String requesttitle, String requestdetails) {
		Employee employee = makeEmployee(username);
		req.submitRequest(employee, requesttitle, requestdetails);
	}
}
