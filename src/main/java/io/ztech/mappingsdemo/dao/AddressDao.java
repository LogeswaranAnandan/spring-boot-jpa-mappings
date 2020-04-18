package io.ztech.mappingsdemo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.constants.ErrorConstants;
import io.ztech.mappingsdemo.entity.Address;
import io.ztech.mappingsdemo.exception.ApplicationException;
import io.ztech.mappingsdemo.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepository addressRepository;

	public List<Address> getAllAddresses() throws Exception {
		return addressRepository.findAll();
	}
	
	public Address getAddressById(int id) throws Exception {
		Optional<Address> address = addressRepository.findById(id);
		if (address.isPresent()) {
			return address.get();
		} else {
			throw new ApplicationException(ErrorConstants.ERR_ADDRESS_NOT_FOUND, ErrorConstants.ERR_ADDRESS_NOT_FOUND_MESSAGE);
		}
	}

	public Address getAddressByEmployeeId(int employeeId) throws Exception {
		Address address = addressRepository.findByEmployeeId(employeeId);
		return address;
	}

}
