package com.pages;



import com.services.EmpService;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

/**
 * Start page of application Tap22.
 */

public class Index
{
	
	@Property
	private String username;
	
	@Property
	private String password;
	
	@InjectComponent("login")
	private Form form;
	
	@InjectComponent(value = "username")
	private TextField usernameField;

	@InjectComponent(value = "password")
	private PasswordField passwordField;


	@Inject
	private EmpService empService;
	
	// Validating the user

	void onValidateFromLogin() {
		boolean flag = false;
		flag = empService.validateEmployee(username,password);
		if(!flag){
			form.recordError(usernameField,"incorrect username");
			form.recordError(passwordField,"incorrect password");
		}
	}
	
	// Validation Passed
	Object onSuccess() {
		return Dashboard.class;
	}
	
}
