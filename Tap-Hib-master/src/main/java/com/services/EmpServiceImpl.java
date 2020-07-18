package com.services;


import com.dao.EmpDAO;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	private final EmpDAO empDAO;

	@Autowired
	public EmpServiceImpl(EmpDAO empDAO){

		this.empDAO = empDAO;
	}

	public boolean validateEmployee(String username,String password) {
		return empDAO.validate(username,password);
	}

	public List<Employee> getAllEmployees(){
		return empDAO.getAll();
	}

	public Employee getEmp(int id){
		return empDAO.getEmployee(id);
	}

	public void addEmployee(Employee e){
		empDAO.addEmployee(e);
	}

}
