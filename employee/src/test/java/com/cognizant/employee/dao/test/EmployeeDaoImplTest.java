package com.cognizant.employee.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.employee.dao.EmployeeDao;
import com.cognizant.employee.dao.EmployeeDaoImpl;
import com.cognizant.employee.model.Employee;

public class EmployeeDaoImplTest {

	ApplicationContext ctx=new AnnotationConfigApplicationContext(com.cognizant.employee.configuration.AppConfig.class);
	EmployeeDao st=(EmployeeDaoImpl)ctx.getBean("employeeDao");
	
	@Test
	public void testInsert() {
		assertEquals(1, st.insert(new Employee(23,"Deb","SR")));
	}
	@Test
	public void testGetAll() {
		assertEquals(6, st.getAll().size());
	}

}
