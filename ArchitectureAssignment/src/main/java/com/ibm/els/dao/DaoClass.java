package com.ibm.els.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.els.bean.Employee;

public class DaoClass implements DaoInterface{
	Connection dbCon;
	String queryToExecute;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public DaoClass(){
		String urlToConnect = "jdbc:mysql://localhost:3306/ibm_training";
    	
    	String userName = "root";
    	
    	String userPassword = "pass@word1";
    	
    	try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        dbCon = DriverManager.getConnection(urlToConnect, userName, userPassword);
        System.out.println("Connected to the database: ibm_training now...");

    	}catch(ClassNotFoundException fnfe) {
    		System.out.println("The connector class was not found.." + fnfe.getMessage());
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("The connection cannot be established." + e.getMessage());
		}
	}
	
	@Override 
	public void putDataToDb(Employee employee) {
		queryToExecute = "insert into employeedata2(EmpName, EmpSalary, EmpDesignation, EmpMedScheme) values (?, ?, ?, ?)";
    	
		try {
			preparedStatement = dbCon.prepareStatement(queryToExecute);
			
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getEmpSalary());
			preparedStatement.setString(3,  employee.getDesignation());
			preparedStatement.setString(4, employee.getScheme());
		} catch (SQLException e) {
			System.out.println("Some issue with prepared statement.." + e.getMessage());
		}
		
		try {
			if(preparedStatement.executeUpdate() > 0) {
				
				System.out.println("The data was added succesfully.");	
			}
		} catch (SQLException e) {
			System.out.println("Some issue while executing the query." + e.getMessage());
		}
    }
	
	@Override
	public void displayEmpData() {
		queryToExecute = "select * from employeedata2";
		
		try {
			preparedStatement = dbCon.prepareStatement(queryToExecute);
		} catch (SQLException e) {
			System.out.println("Some issue with prepared statement.." + e.getMessage());
		}
		try {
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.print("Employee [Id: " + resultSet.getInt("EmpId"));
				System.out.print(" , Name: " + resultSet.getString("EmpName"));
				System.out.print(" , Salary: " + resultSet.getInt("EmpSalary"));
				System.out.print(" , Designation: " + resultSet.getString("EmpDesignation"));
				System.out.print(" , Medical Scheme: " + resultSet.getString("EmpMedScheme"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Some issue while executing the query : "  + e.getMessage());
		}
	}
}
