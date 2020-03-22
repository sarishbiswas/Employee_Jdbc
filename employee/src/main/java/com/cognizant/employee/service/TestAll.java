package com.cognizant.employee.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.cognizant.employee.configuration.AppConfig;
import com.cognizant.employee.dao.EmployeeDao;
import com.cognizant.employee.dao.EmployeeDaoImpl;
import com.cognizant.employee.model.Employee;

public class TestAll {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeDao dao= (EmployeeDaoImpl)ctx.getBean("employeeDao");
		System.out.println(dao.insert(new Employee(2,"Debu","Mukherjee")));
		List<Employee>list=dao.getAll();
		System.out.println(list);
		ctx.close();
	}

}
