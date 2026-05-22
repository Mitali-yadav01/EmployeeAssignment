package com.mitali.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitali.customException.ResourceNotFoundException;
import com.mitali.entity.Employee;
import com.mitali.repository.EmployeeRepository;

@Service
public class EmployeeService {

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Employee getEmployeeById(int id) {
	        return employeeRepository.findById(id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException(
	                                "Employee not found with id: " + id));
	    }

	    public Employee getTopEarner() {
	        return employeeRepository.findAll()
	                .stream()
	                .max(Comparator.comparing(Employee::getSalary))
	                .orElseThrow(() ->
	                        new ResourceNotFoundException(
	                                "No employees found"));
	    }
	    
	    public Employee addEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }
	
}
