package com.mitali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitali.entity.Employee;
import com.mitali.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployees();
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(
            @PathVariable int id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id));
    }

   
    @GetMapping("/top-earner")
    public ResponseEntity<Employee> getTopEarner() {

        return ResponseEntity.ok(
                employeeService.getTopEarner());
    }
    
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @Valid @RequestBody Employee employee) {

        Employee savedEmployee =
                employeeService.addEmployee(employee);

        return ResponseEntity.ok(savedEmployee);
    }
}