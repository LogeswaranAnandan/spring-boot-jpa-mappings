package io.ztech.mappingsdemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "Employee")
@NamedEntityGraphs({
        @NamedEntityGraph(name="ADDRESS_ONLY", attributeNodes = {
                @NamedAttributeNode(value = "address")
        }),
        @NamedEntityGraph(name="EXCLUDE_SPECIALITIES", attributeNodes = {
                @NamedAttributeNode("address"),
                @NamedAttributeNode("department")
        })
})
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  private String email;

  private BigInteger phoneNumber;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id")
  private Address address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "employee_speciality",
          joinColumns = {@JoinColumn(name = "employee_id")},
          inverseJoinColumns = {@JoinColumn(name = "speciality_id")}
  )
  private List<Speciality> specialities;
}
