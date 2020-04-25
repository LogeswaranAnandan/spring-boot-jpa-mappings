package io.ztech.mappingsdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ztech.mappingsdemo.delegate.DepartmentDelegate;
import io.ztech.mappingsdemo.entity.Department;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	DepartmentDelegate departmentDelegate;
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") int id) throws Exception {
		return departmentDelegate.getDepartmentById(id);
	}
	
}
