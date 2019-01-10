package com.revature.empremsys.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOParent {
	private static String url = "jdbc:postgresql://elmer.db.elephantsql.com:5432/lkupdzxk";
	private static String username = "lkupdzxk";
	private static String password = "17iIC-T_FF1MM1W9G1L08wzqgsPQj5X3";
	protected static Connection connection = createConnection();
	
	private static Connection createConnection() {
		try {
	          Class.forName("org.postgresql.Driver");
	      } catch (ClassNotFoundException ex) {

	      }
		 try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		 return connection;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}

