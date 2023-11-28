package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    List<Employee> findBySalaryGreaterThan(BigDecimal salary);

    // display all employees with salaries with less than ' '
    List<Employee> findBySalaryIsLessThanEqual(BigDecimal salary);

    //display all employees that has been hired between ' ' and ' '
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    // display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalary(BigDecimal salary);

    //display top unique 3 employees that is making less than ' '
    List<Employee> findDistinctTop3BySalaryLessThan(BigDecimal salary);

    // display all employees that do not have email address
    List<Employee> findByEmailIsNull();
    @Query("Select e from Employee e where e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();
    @Query("Select e.salary from Employee e where e.email = 'sdubber7@t-online.de' ")
    Integer getEmployeeSalary();
    @Query("Select e from Employee e where e.email=?1")
    Optional<Employee> getEmployeeDetail(String email);

    @Query("Select e from Employee e where e.email=?1 and e.salary=?2")
    Employee getEmployeeDetail(String email,int salary);
}
