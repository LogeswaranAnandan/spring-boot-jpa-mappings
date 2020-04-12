package io.ztech.mappingsdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ztech.mappingsdemo.delegate.EmployeeDelegate;
import io.ztech.mappingsdemo.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDelegate employeeDelegate;
	
	@GetMapping
	public List<Employee> getAllEmployees() throws Exception {
		return employeeDelegate.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") int id) throws Exception {
		return employeeDelegate.getEmployeeById(id);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) throws Exception {
		return employeeDelegate.addEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws Exception {
		return employeeDelegate.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws Exception {
		employeeDelegate.deleteEmployee(id);
	}
	
	
};
