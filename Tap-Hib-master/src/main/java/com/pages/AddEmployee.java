package com.pages;

import com.model.Employee;
import com.services.EmpService;
import com.services.EmpServiceImpl;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

public class AddEmployee {

	@Property
	private Integer id;

	@Property
	private Integer age;

	@Property
	private String name;

	@Property
	private String address;

	@Property
	private String username;

	@Property
	private String password;

	@InjectComponent("add")
	private Form form;

//	@Inject
//	private Session session;

	@Inject
	private EmpService empService;
	

	Object onSuccess() {
		//EmpServiceImpl empService = new EmpServiceImpl(empDAO);


		Employee emp = new Employee();
		emp.setId(id);
		emp.setAge(age);
		emp.setName(name);
		emp.setUsername(username);
		emp.setPassword(password);
		emp.setAddress(address);
		empService.addEmployee(emp);
		return Dashboard.class;
	}
}
