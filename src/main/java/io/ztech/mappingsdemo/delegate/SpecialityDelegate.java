package io.ztech.mappingsdemo.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ztech.mappingsdemo.dao.SpecialityDao;
import io.ztech.mappingsdemo.entity.Speciality;

@Service
public class SpecialityDelegate {
	
	@Autowired
	SpecialityDao specialityDao;
	
	public List<Speciality> getAllSpecialities() throws Exception {
		return specialityDao.getAllSpecialities();
	}
	
	public Speciality getSpecialityById(int id) throws Exception {
		return specialityDao.getSpecialityById(id);
	}
	
}
