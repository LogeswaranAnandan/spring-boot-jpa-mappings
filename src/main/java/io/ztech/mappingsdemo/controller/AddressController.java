package io.ztech.mappingsdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ztech.mappingsdemo.delegate.AddressDelegate;
import io.ztech.mappingsdemo.entity.Address;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressDelegate addressDelegate;

    @GetMapping
    public List<Address> getAllAddresses() throws Exception {
        return addressDelegate.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable("id") int id) throws Exception {
        return addressDelegate.getAddressById(id);
    }

    @GetMapping("/employees/{employeeId}")
    public Address getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) throws Exception {
        return addressDelegate.getAddressByEmployeeId(employeeId);
    }

}
