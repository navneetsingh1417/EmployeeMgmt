package com.pages;

import com.model.Employee;
import com.services.EmpService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ViewEmployee {

	@Property
	private int id;
	
	void onActivate(int id) {
		this.id = id;
	}
	
	@Property
	private Employee employee;

//	@Inject
//	private Session session;

	@Inject
	private EmpService empService;
	
	void setupRender() {
		//EmpServiceImpl employeeService = new EmpServiceImpl(empDAO);
		this.employee = (Employee) empService.getEmp(id);
	}
	
	
}
