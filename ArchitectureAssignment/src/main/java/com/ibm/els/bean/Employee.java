package com.ibm.els.bean;

public class Employee {
	private int empSalary;
	private String empName, empDesignation, scheme;
	
	public Employee(int salary, String name) {
		this.empSalary = salary;
		this.empName = name;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void setDesignation(String designation) {
		this.empDesignation = designation;
	}
	
	public String getDesignation() {
		return this.empDesignation;
	}
	
	public String getScheme() {
		return this.scheme;
	}
	
	public void setScheme(String scheme) {
		this.scheme = scheme;
	}
}
