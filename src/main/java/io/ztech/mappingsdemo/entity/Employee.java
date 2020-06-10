package io.ztech.mappingsdemo.entity;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private BigInteger phoneNumber;

	@Column(name = "salary")
	private int salary;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "employee_speciality", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "speciality_id") })
	private List<Speciality> specialities;

	public List<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
