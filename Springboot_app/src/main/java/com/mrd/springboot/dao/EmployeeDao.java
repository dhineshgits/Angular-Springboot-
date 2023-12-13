package com.mrd.springboot.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrd.springboot.model.Employee;
import com.mrd.springboot.repository.EmployeeRepository;

@Component
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(long id) {
		Optional<Employee> emp=employeeRepository.findById((int) id);
         return emp;
        	
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Employee employee) {
	 employeeRepository.delete(employee);
	}
}
