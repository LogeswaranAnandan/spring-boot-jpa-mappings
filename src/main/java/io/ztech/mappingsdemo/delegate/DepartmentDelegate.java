package io.ztech.mappingsdemo.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ztech.mappingsdemo.dao.DepartmentDao;
import io.ztech.mappingsdemo.entity.Department;

@Service
public class DepartmentDelegate {
	
	@Autowired
	DepartmentDao departmentDao;
	
	public List<Department> getAllDepartments() throws Exception {
		return departmentDao.getAllDepartments();
	}
	
	public Department getDepartmentById(int id) throws Exception {
		return departmentDao.getDepartmentById(id);
	}

}
