package com.pages;

import com.model.Employee;
import com.services.EmpService;
import com.services.EmpServiceImpl;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

public class SeeAllEmployees {

	@Property
	private List<Employee> employees;
	
	@Property
	private Employee employee;

//	@Inject
//	private Session session;

	@Inject
	private EmpService empService;

	void setupRender() {
		//EmpServiceImpl emp = new EmpServiceImpl(empDAO);
		this.employees = empService.getAllEmployees();
	}
	
	
	
}
