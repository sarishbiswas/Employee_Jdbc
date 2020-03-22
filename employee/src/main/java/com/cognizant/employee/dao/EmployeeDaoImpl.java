package com.cognizant.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.employee.model.Employee;
@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int insert(Employee employee) {
		String sql = "insert into employee1 values(?,?,?)";
		int result = getJdbcTemplate().update(sql, employee.getId(),employee.getFirstName(),employee.getLastName());
		System.out.println("inside insert");
		return result;
	}

	public List<Employee> getAll() {
		 List <Employee> employee = jdbcTemplate.query("SELECT * FROM employee1", new BeanPropertyRowMapper(Employee.class));
	        return employee;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
