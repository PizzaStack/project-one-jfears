package com.revature.empremsys.daos;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOManager {
	protected DAOParent dao = new DAOParent();
	
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
	
	public String getname(String username) {
		String sql = "select manfirstname, emplastname from manager where manusername=\'" + username +"\'";
		String name = "";
		try {
			Statement statement = dao.connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				name = rs.getString("firstname");
				name = name + rs.getString("lastname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
}
