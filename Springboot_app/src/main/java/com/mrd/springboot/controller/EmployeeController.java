package com.mrd.springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.lang.String;

import com.mrd.springboot.dao.EmployeeDao;
import com.mrd.springboot.exception.ResourceNotFoundException;
import com.mrd.springboot.model.Employee;
import com.mrd.springboot.repository.EmployeeRepository;
import com.mrd.springboot.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
     EmployeeService employeeService;
	
	@GetMapping("/get")
	@ResponseBody
	public String get() {
		return "hello world";
	}

	@PostMapping("/addemployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		return employeeService.updateEmployee(id,employeeDetails);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		return employeeService.deleteEmployee(id);
	}
	
}
