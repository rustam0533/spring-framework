package com.cydeo.repository;

import com.cydeo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // not equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    // less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    // greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    // before
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> getEmployeeHireDateBefore(LocalDate date);

    // between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1,int salary2);

    //null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeEmailIsNull();

    //notnull
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeEmailIsNotNull();

    // sorting in ascending order
    @Query("select e from Employee e order by e.salary")
    List<Employee> getEmployeeSalaryOrderAsc();

    // sorting in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeSalaryOrderDesc();

    @Query(value = "select * from employees where salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailBySalary(int salary);
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> getEmployeeSalary(@Param("salary") int salary);
    @Modifying
    @Transactional
    @Query("update Employee e set e.email = 'admin@email.com' where e.id=:id")
    void updateEmployeeJPQL(@Param ("id") int id);

    @Modifying
    @Transactional
    @Query(value= "update employees  set email = 'admin@email.com' where id=:id",nativeQuery = true)
    void updateEmployeeNativeQuery(@Param ("id") int id);

List<Employee> retrieveDepartmentByDivision(String division);
}
