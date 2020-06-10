package io.ztech.mappingsdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
