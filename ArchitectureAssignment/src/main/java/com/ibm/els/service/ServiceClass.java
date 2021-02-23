package com.ibm.els.service;

import com.ibm.els.bean.Employee;
import com.ibm.els.dao.DaoClass;

public class ServiceClass implements ServiceInterface {
	Employee newEmployee;
	DaoClass dao = new DaoClass();

	@Override
	public void enterEmployeeData(Employee employee) {
		newEmployee = employee;
		int salary = newEmployee.getEmpSalary();
		if (salary <= 5000) {
			newEmployee.setDesignation("Clerk");
			newEmployee.setScheme("No scheme");
		} else if (salary > 5000 && salary <= 20000) {
			newEmployee.setDesignation("System Associate");
			newEmployee.setScheme("Scheme C");
		} else if (salary > 20000 && salary <= 40000) {
			newEmployee.setDesignation("Programmer");
			newEmployee.setScheme("Scheme B");
		} else if (salary > 40000) {
			newEmployee.setDesignation("Manager");
			newEmployee.setScheme("Scheme A");
		}
		dao.putDataToDb(newEmployee);
	}

	@Override 
	public void displayEmpData() {
		dao.displayEmpData();
	}

}
