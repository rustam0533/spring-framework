package com.cydeo.bootstrap;

import com.cydeo.repository.CourseRepository;
import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final CourseRepository courseRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, CourseRepository courseRepository) {
        this.regionRepository = regionRepository;

        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------REGION START-------------------");

        System.out.println("findByCountry: " + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findCountryContaining: " + regionRepository.findByCountryContaining("Canada"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Canada"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------------REGION END-------------------");

        System.out.println("-----------------------DEPARTMENT START-------------------");


        System.out.println("findByCountry: " + departmentRepository.findByDepartment("Toys"));
        System.out.println("findDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));
        System.out.println("findByCountryContainingOrderByCountry: " + regionRepository.findByCountryContainingOrderByCountry("Canada"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));
        System.out.println("-----------------------DEPARTMENT END-------------------");


        System.out.println("-----------------------EMPLOYEE START-------------------");

        System.out.println("getEmployeeDetail: " + employeeRepository.getEmployeeDetail());
        System.out.println("////////////////////////////////////////");
        System.out.println("getEmployeeSalary: " + employeeRepository.getEmployeeSalary());

        System.out.println("-----------------------EMPLOYEE END-------------------");


        System.out.println("-----------------------COURSE START-------------------");

        // implement method created inside course repository class therefore firstly we need to inject it to be able to use its methods
         courseRepository.findByCategory("Spring").forEach(System.out:: println);

        System.out.println("////////////////////////////////////////");

         courseRepository.findByCategoryOrderByName("Spring").forEach(System.out::println);

        System.out.println("////////////////////////////////////////");
        System.out.println(courseRepository.existsByName("JavaScript for All"));

        System.out.println("////////////////////////////////////////");
        System.out.println(courseRepository.countByCategory("Spring"));

        System.out.println("////////////////////////////////////////");
        System.out.println(courseRepository.findByNameStartingWith("Scalable"));
        System.out.println("////////////////////////////////////////");
        courseRepository.streamByCategory("Spring").forEach(System.out::println);

        System.out.println("-----------------------COURSE END-------------------");

    }

    }


