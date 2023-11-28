package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // display all employees with email address.
    List<Employee> findByEmail(String email);

    // Display all employees with first name '' and last name ' ' also show all employees with email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName,String email);
   //display all employees that first name is not ' '

    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ' '
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than ' '
    List<Employee> findBySalaryGreaterThan(Integer salary);

    // display all employees with salaries with less than ' '
    List<Employee> findBySalaryIsLessThanEqual(Integer salary);

    //display all employees that has been hired between ' ' and ' '
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalarySalaryDesc(Integer salary);

    //display top unique 3 employees that is making less than ' '
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // display all employees that do not have email address
    List<Employee> findByEmailIsNull();
}
