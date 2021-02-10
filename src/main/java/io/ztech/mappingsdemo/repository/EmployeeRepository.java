package io.ztech.mappingsdemo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.ztech.mappingsdemo.entity.Employee;

import javax.persistence.NamedEntityGraph;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Entity graph takes the relational/mapped entities as parameters and EAGER loads those entities.
    // Entity graph overrides the FetchType that is set in the entity mapping annotation.
    @Override
    @EntityGraph(attributePaths = {"address", "department", "specialities"})
    List<Employee> findAll();

    @Override
//    @EntityGraph(value = "ADDRESS_ONLY")
    Optional<Employee> findById(Integer id);
}
