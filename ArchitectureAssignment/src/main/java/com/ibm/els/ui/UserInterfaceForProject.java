package com.ibm.els.ui;

import java.util.Scanner;

import com.ibm.els.bean.Employee;
import com.ibm.els.service.ServiceClass;

public class UserInterfaceForProject {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean breakOutOfLoop = false;
		ServiceClass services = new ServiceClass();
		
		while(true) {
		System.out.println("Task Options: ");
		System.out.println("\n 1. Enter Employee Data \n 2. Display Employee Data \n 3. Exit");
		System.out.print("Please enter the option number: ");
		
		int optionNum = scan.nextInt();
		scan.nextLine();
			switch(optionNum) {
				case 1:
					System.out.print("Please enter name of Employee: ");
					String empName = scan.nextLine();
					System.out.print("Please enter your salary(in numbers): ");
					int empSalary = scan.nextInt();
					scan.nextLine();
					Employee newEmployee = new Employee(empSalary, empName);
					services.enterEmployeeData(newEmployee);
					break;
				case 2:
					services.displayEmpData();
					break;
				case 3: 
					breakOutOfLoop = true;
					break;
			}
			if(breakOutOfLoop) {
				break;
			}
		}
		
	}

}
