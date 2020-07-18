package com.dao;

import com.model.Employee;

import java.util.List;

public interface EmpDAO {

    boolean validate(String username, String password);
    List<Employee> getAll();
    Employee getEmployee(int id);
    void addEmployee(Employee e);
}
