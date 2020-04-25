package io.ztech.mappingsdemo.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ztech.mappingsdemo.dao.DepartmentDao;
import io.ztech.mappingsdemo.entity.Department;

@Service
public class DepartmentDelegate {
	
	@Autowired
	DepartmentDao departmentDao;
	
	public Department getDepartmentById(int id) throws Exception {
		return departmentDao.getDepartmentById(id);
	}

}
