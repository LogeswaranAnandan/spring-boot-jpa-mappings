package io.ztech.mappingsdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ztech.mappingsdemo.delegate.SpecialityDelegate;
import io.ztech.mappingsdemo.entity.Speciality;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {
	
	@Autowired
	SpecialityDelegate specialityDelegate;
	
	@GetMapping
	public List<Speciality> getAllSpecialities() throws Exception {
		return specialityDelegate.getAllSpecialities();
	}
	
	@GetMapping("/{id}")
	public Speciality getSpecialityById(@PathVariable("id") int id) throws Exception {
		return specialityDelegate.getSpecialityById(id);
	}

}
