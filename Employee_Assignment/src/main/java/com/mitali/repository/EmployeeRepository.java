package com.mitali.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitali.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
