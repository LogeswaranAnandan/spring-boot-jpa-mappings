package io.ztech.mappingsdemo.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ztech.mappingsdemo.constants.ErrorConstants;
import io.ztech.mappingsdemo.dao.EmployeeDao;
import io.ztech.mappingsdemo.entity.Employee;
import io.ztech.mappingsdemo.exception.ApplicationException;

@Service
public class EmployeeDelegate {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployees() throws Exception {
		return employeeDao.getAllEmployees();
	}
	
	public Employee getEmployeeById(int id) throws Exception {
		return employeeDao.getEmployeeById(id);
	}
	
	public Employee addEmployee(Employee employee) throws Exception {
		return employeeDao.addEmployee(employee);
	}
	
	public Employee updateEmployee(int id, Employee employee) throws Exception {
		if (employee.getId() == id) {
			if (employeeDao.doesEmployeeExists(id)) {
				return employeeDao.updateEmployee(employee);
			} else {
				throw new ApplicationException(ErrorConstants.ERR_EMPLOYEE_NOT_FOUND, ErrorConstants.ERR_EMPLOYEE_NOT_FOUND_MESSAGE);
			}
		} else {
			throw new ApplicationException(ErrorConstants.ERR_EMPLOYEE_ID_MISMATCH, ErrorConstants.ERR_EMPLOYEE_ID_MISMATCH_MESSAGE);
		}
	}
	
	public void deleteEmployee(int id) throws Exception {
		if (employeeDao.doesEmployeeExists(id)) {
			employeeDao.deleteEmployee(id);
		} else {
			throw new ApplicationException(ErrorConstants.ERR_EMPLOYEE_NOT_FOUND, ErrorConstants.ERR_EMPLOYEE_NOT_FOUND_MESSAGE);
		}
	}

}
