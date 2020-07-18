package com.pages;

import org.apache.tapestry5.annotations.Property;

public class Login
{


  @Property
  private String email;

  @Property
  private String password;
  
  @Property()
  private String message;


  

  Object onValidateFromLogin()
  {
    if ( !email.equals("abc@gmail.com") && !password.equals("123")) {
    	message = "Incorrect Credentials ";
    	return Login.class;
    }else {
    	return Dashboard.class;
    }
  }

//  Object onSuccessFromLogin()
//  {
//    
//
//    return Dashboard.class;
//  }
//
//  Object onFailureFromLogin()
//  {
//    return Login.class;
//  }

}
