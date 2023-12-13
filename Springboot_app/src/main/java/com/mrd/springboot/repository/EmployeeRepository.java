package com.mrd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mrd.springboot.model.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
