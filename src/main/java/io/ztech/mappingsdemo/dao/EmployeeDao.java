package io.ztech.mappingsdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.constants.ErrorConstants;
import io.ztech.mappingsdemo.entity.Employee;
import io.ztech.mappingsdemo.exception.ApplicationException;
import io.ztech.mappingsdemo.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Employee getEmployeeById(int id) throws Exception {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new ApplicationException(ErrorConstants.ERR_EMPLOYEE_NOT_FOUND, ErrorConstants.ERR_EMPLOYEE_NOT_FOUND_MESSAGE);
		}
	}
	
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}
	
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}
	
	public void deleteEmployee(int id) throws Exception {
		employeeRepository.deleteById(id);
	}
	
	public boolean doesEmployeeExists(int id) {
		return employeeRepository.existsById(id);
	}
	
}
