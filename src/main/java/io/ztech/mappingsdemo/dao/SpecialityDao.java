package io.ztech.mappingsdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.entity.Speciality;
import io.ztech.mappingsdemo.exception.ApplicationException;
import io.ztech.mappingsdemo.repository.SpecialityRepository;

@Repository
public class SpecialityDao {
	
	@Autowired
	SpecialityRepository specialityRepository;
	
	public List<Speciality> getAllSpecialities() throws Exception {
		return specialityRepository.findAll();
	}
	
	public Speciality getSpecialityById(int id) throws Exception {
		Optional<Speciality> speciality = specialityRepository.findById(id);
		if (speciality.isPresent()) {
			return speciality.get();
		} else {
			throw new ApplicationException();
		}
	}

}
