package com.springcoredemo2;

import org.springframework.stereotype.Component;

@Component
public class Department {
	
	private String departmentId;
	private String departmentName;
	
	public String getDepartmentId() {
		return departmentId;
	}
	
	/**
	 * 
	 * @param departmentId
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

}
