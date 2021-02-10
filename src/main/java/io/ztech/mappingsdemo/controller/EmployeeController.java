package io.ztech.mappingsdemo.controller;

import java.util.List;

import io.ztech.mappingsdemo.annotation.IgnoreResponseWrapper;
import io.ztech.mappingsdemo.dto.EmployeeDto;
import io.ztech.mappingsdemo.entity.Address;
import io.ztech.mappingsdemo.entity.Speciality;
import io.ztech.mappingsdemo.repository.AddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ztech.mappingsdemo.delegate.EmployeeDelegate;
import io.ztech.mappingsdemo.entity.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeDelegate employeeDelegate;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;

	@IgnoreResponseWrapper
	@GetMapping
	public List<Employee> getAllEmployees() throws Exception {
		return employeeDelegate.getAllEmployees();
	}

	@IgnoreResponseWrapper
	@GetMapping("/{id}")
	public EmployeeDto getEmployee(@PathVariable("id") int id) throws Exception {
		Employee employee = employeeDelegate.getEmployeeById(id);
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//		EmployeeDto employeeDto = new EmployeeDto();
//		employeeDto.setAddress(employee.getAddress());
//		employeeDto.setSpecialities(employee.getSpecialities());
		return employeeDto;
	}

	@IgnoreResponseWrapper
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) throws Exception {
		Address address = employee.getAddress();
		Address savedAddress = addressRepository.save(address);

		// Type 1
//		employee.setAddress(savedAddress);

		// Type 2
		Address addressMappedEntity = new Address();
		addressMappedEntity.setId(savedAddress.getId());
		employee.setAddress(addressMappedEntity);

		return employeeDelegate.addEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) throws Exception {
		return employeeDelegate.updateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") int id) throws Exception {
		employeeDelegate.deleteEmployee(id);
	}
	
	
};
