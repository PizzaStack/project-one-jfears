package com.revature.empremsys.entity;

public class Manager{
	protected String username;
	protected String password;
	protected int empId;
	
	public Manager() {};
	
	public Manager(String username, String password) {
		this.username = username;
		this.password = password;
	};
}
