package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {  // we need this interface in order to be able to save objects to our table
                                                                                   // JPARepository has ready methods to use which we can use to save our objects
}
