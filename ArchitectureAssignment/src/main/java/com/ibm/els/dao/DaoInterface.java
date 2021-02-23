package com.ibm.els.dao;

import com.ibm.els.bean.Employee;

public interface DaoInterface {
	public void putDataToDb(Employee employee);
	public void displayEmpData();
}
