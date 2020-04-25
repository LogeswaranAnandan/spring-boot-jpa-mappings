package io.ztech.mappingsdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.entity.Department;
import io.ztech.mappingsdemo.exception.ApplicationException;
import io.ztech.mappingsdemo.repository.DepartmentRepository;

@Repository
public class DepartmentDao {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() throws Exception {
		return departmentRepository.findAll();
	}
	
	public Department getDepartmentById(int id) throws Exception {
		Optional<Department> department = departmentRepository.findById(id);
		if (department.isPresent()) {
			return department.get();
		} else {
			throw new ApplicationException();
		}
	}

}
