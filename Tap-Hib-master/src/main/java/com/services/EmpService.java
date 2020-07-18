package com.services;

import com.model.Employee;

import java.util.List;

public interface EmpService {
    public boolean validateEmployee(String username,String password);
    public List<Employee> getAllEmployees();
    public Employee getEmp(int id);
    public void addEmployee(Employee e);
}
