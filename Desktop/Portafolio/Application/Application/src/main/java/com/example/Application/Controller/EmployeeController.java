package com.example.Application.Controller;

import com.example.Application.Model.Employee;
import com.example.Application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee employeeCreated = employeeService.create(employee);
        return employeeCreated;
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> employeeById(@PathVariable("id") long id) {
        Employee getById = employeeService.findById(id);
            return ResponseEntity.ok(getById);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable("id") long id, @RequestBody Employee employeeData) {
        Employee update = employeeService.edit(id, employeeData);

        return ResponseEntity.ok(update);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        long employeeDelete = employeeService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
