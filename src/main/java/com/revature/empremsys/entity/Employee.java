package com.revature.empremsys.entity;

import java.util.Random;

public class Employee extends Manager{
	
	//protected String email;
	protected String firstName;
	protected String lastName;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String username, String password) {
		super(username, password);
		this.firstName = firstName;
		this.lastName = lastName;
		setID();
	}
	
	public void setID() {
		Random rand = new Random();
		this.empId = rand.nextInt(10)+1;
	}
}
