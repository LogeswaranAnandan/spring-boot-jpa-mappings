package io.ztech.mappingsdemo.dto;

import io.ztech.mappingsdemo.entity.Address;
import io.ztech.mappingsdemo.entity.Department;
import io.ztech.mappingsdemo.entity.Speciality;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigInteger;
import java.util.List;

@Data
public class EmployeeDto {
  private int id;
  private String firstName;
  private String lastName;
  private String email;
  private BigInteger phoneNumber;
  private Address address;
  private Department department;
  private List<Speciality> specialities;
}
