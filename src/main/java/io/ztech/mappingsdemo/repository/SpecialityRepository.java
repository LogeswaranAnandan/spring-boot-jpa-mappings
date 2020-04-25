package io.ztech.mappingsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.entity.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {

}
