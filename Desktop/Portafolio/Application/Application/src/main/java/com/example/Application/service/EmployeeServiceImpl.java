package com.example.Application.service;

import com.example.Application.Model.Employee;
import com.example.Application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        String fullName = getFullName(employee);
        employee.setFullName(fullName);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee edit(long id, Employee employee) {

        Employee updateEmployee = employeeRepository.findById(id).get();

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setFullName(getFullName(employee));
        updateEmployee.setEmailId(employee.getEmailId());

        employeeRepository.save(employee);

        return employeeRepository.findById(id).get();
    }

    public long delete(long id){
        Employee employeeDelete = employeeRepository.findById(id).get();

        employeeRepository.delete(employeeDelete);

        return employeeDelete.getId();
    }

    public String getFullName(Employee employee){ return employee.getFirstName() + " " + employee.getLastName(); }
}
