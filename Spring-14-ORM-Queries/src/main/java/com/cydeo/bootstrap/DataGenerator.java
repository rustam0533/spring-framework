package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;

        this.departmentRepository = departmentRepository;
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
    }
}
