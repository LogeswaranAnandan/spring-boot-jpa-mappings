package io.ztech.mappingsdemo.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import io.ztech.mappingsdemo.dto.EmployeeDto;
import io.ztech.mappingsdemo.entity.Employee;
import io.ztech.mappingsdemo.entity.Speciality;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ObjectMapperConfig {

  @Bean
  public Module datatypeHibernateModule() {
    return new Hibernate5Module();
  }

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    PropertyMap<Employee, EmployeeDto> timeCardMap = new PropertyMap<Employee, EmployeeDto>() {
      protected void configure() {
        System.out.println("Setting Speciality-------");
        map().setAddress(source.getAddress());
        map().setSpecialities(source.getSpecialities());
//        List<Speciality> specialityList = new ArrayList<Speciality>();
//        Speciality speciality = new Speciality(10, "test");
//        specialityList.add(speciality);
//        map().setSpecialities(specialityList);
      }
    };

    modelMapper.addMappings(timeCardMap);

    return modelMapper;
  }

}
