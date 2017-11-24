package com.workflow.workflow.bean;

public class Resource {
	
	private String name;
	private String role;
	private String allocationPercentage;
	private String month;
	private String effort;
	public Resource(){
		
	}
	public Resource(String name, String role, String allocationPercentage, String month, String effort) {
		super();
		this.name = name;
		this.role = role;
		this.allocationPercentage = allocationPercentage;
		this.month = month;
		this.effort = effort;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAllocationPercentage() {
		return allocationPercentage;
	}
	public void setAllocationPercentage(String allocationPercentage) {
		this.allocationPercentage = allocationPercentage;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getEffort() {
		return effort;
	}
	public void setEffort(String effort) {
		this.effort = effort;
	}
	
	

}
