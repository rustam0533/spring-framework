package com.cydeo.bootstrap;

import com.cydeo.entity.Department;
import com.cydeo.entity.Employee;
import com.cydeo.entity.Region;
import com.cydeo.enums.Gender;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    EmployeeRepository employeeRepository;
    DepartmentRepository departmentRepository;

    public DataGenerator(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {  // we need to have this constructor here for AutoWiring
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeeList = new ArrayList<>();  // we create here empty list for the table
        List<Department> departmentList = new ArrayList<>(); // we create here empty list for the table


        Employee e1 = new Employee("Berrie","Manuew","bmanuew@test.com", LocalDate.of(2007,04,23),35000, Gender.F);
        Employee e2 = new Employee("Jack","Manuel","j.manuel@test.com", LocalDate.of(2005,05,03),99000, Gender.M);
        Employee e3 = new Employee("Sam","Uncle","samUncle@test.com", LocalDate.of(2004,07,12),125000, Gender.M);
        Employee e4 = new Employee("Teddy","Bear","t.bear@test.com", LocalDate.of(2003,02,16),50000, Gender.F);
        Employee e5 = new Employee("Jackie","Smith","j.smith@test.com", LocalDate.of(2001,11,10),85000, Gender.F);


        Department d1 = new Department("Sports","Outdoors");
        Department d2 = new Department("Tools","Hardware");
        Department d3 = new Department("Clothing","Home");
        Department d4 = new Department("Phones & Tablets","Electronics");
        Department d5 = new Department("Computers","Electronics");

        Region r1 = new Region("Southwest","United States");
        Region r2 = new Region("Central","Asia");
        Region r3 = new Region("Quebec","Canada");
        Region r4 = new Region("Central","Asia");
        Region r5 = new Region("Northwest","United States");

        e1.setDepartment(d1);
        e2.setDepartment(d2);
        e3.setDepartment(d3);
        e4.setDepartment(d4);
        e5.setDepartment(d5);

        e1.setRegion(r1);
        e2.setRegion(r2);
        e3.setRegion(r3);
        e4.setRegion(r4);
        e5.setRegion(r5);

        employeeList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepository.saveAll(employeeList);
       // departmentRepository.saveAll(departmentList);



    }
}
