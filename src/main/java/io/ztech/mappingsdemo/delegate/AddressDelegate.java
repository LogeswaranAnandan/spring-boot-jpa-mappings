package io.ztech.mappingsdemo.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ztech.mappingsdemo.constants.ErrorConstants;
import io.ztech.mappingsdemo.dao.AddressDao;
import io.ztech.mappingsdemo.dao.EmployeeDao;
import io.ztech.mappingsdemo.entity.Address;
import io.ztech.mappingsdemo.exception.ApplicationException;

@Service
public class AddressDelegate {

    @Autowired
    AddressDao addressDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Address> getAllAddresses() throws Exception {
        return addressDao.getAllAddresses();
    }

    public Address getAddressById(int id) throws Exception {
        return addressDao.getAddressById(id);
    }

}
