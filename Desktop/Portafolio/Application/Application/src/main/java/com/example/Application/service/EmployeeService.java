package com.example.Application.service;


import com.example.Application.Model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee create(Employee employee);
    Employee findById(long id);
    Employee edit(long id, Employee employee);
    long delete(long id);

}
