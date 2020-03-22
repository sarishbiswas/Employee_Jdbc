package com.cognizant.employee.dao;

import java.util.List;

import com.cognizant.employee.model.Employee;

public interface EmployeeDao {
	public int insert(Employee employee);
	
	public List<Employee> getAll();

}
