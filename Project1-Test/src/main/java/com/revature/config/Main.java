package com.revature.config;

import com.revature.dao.EmployeeDAO;
import com.revature.pojo.Employee;

public class Main {
	
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setUsername("mark");
		emp.setPassword("123");
		emp.setFirstName("amrk");
		emp.setLastName("Smith");
		emp.setEmail("m@gmail.com");
		
		EmployeeDAO dao = new EmployeeDAO();
		
		//dao.saveEmployee(emp);
	}
}
