package com.revature.empremsys.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOEmployee {
	protected DAOParent dao = new DAOParent();
	
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
}
