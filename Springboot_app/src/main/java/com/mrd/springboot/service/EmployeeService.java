package com.mrd.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mrd.springboot.dao.EmployeeDao;
import com.mrd.springboot.exception.ResourceNotFoundException;
import com.mrd.springboot.model.Employee;

@Service
public class EmployeeService extends ResourceNotFoundException {

	@Autowired
	EmployeeDao dao;

	
	public Employee createEmployee(Employee employee) {
		return dao.createEmployee(employee);
	}

	public List<Employee> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	public ResponseEntity<Employee> getEmployeeById(long id) {
        Employee employee=dao.getEmployeeById(id)
        		.orElseThrow(() ->new ResourceNotFoundException("Employee not found in this id: "+id));
        return ResponseEntity.ok(employee);
 	
	}

	public ResponseEntity<Employee> updateEmployee(Long id, Employee employeeDetails) {
        Employee employee=dao.getEmployeeById(id)
        		.orElseThrow(() ->new ResourceNotFoundException("Employee not found in this id: "+id));
        
        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setPassword(employeeDetails.getPassword());
        employee.setMobileno(employeeDetails.getMobileno());
        employee.setDob(employeeDetails.getDob());
        employee.setGender(employeeDetails.getGender());
        
         Employee updatedEmployee =  dao.updateEmployee(employee);
         return ResponseEntity.ok(updatedEmployee);
	}

	public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) {
	 
		 Employee employee=dao.getEmployeeById(id)
	        		.orElseThrow(() ->new ResourceNotFoundException("Employee not found in this id: "+id));
		 
	 dao.deleteEmployee(employee);
	 Map<String,Boolean> response = new HashMap<>();
	 response.put("deleted",Boolean.TRUE);
	 return ResponseEntity.ok(response);
	}
	
	

}
