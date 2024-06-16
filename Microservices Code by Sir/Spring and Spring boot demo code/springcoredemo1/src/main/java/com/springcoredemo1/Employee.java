package com.springcoredemo1;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private String employeeId;
	private String employeeName;
	
	//this will inject the department bean into this property using the setter method
	@Autowired
	private Department department;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

}
