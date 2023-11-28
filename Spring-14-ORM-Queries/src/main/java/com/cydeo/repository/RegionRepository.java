package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {


    // display all regions in canada
   List<Region> findByCountry(String country);  // select * from region where country is ......

    // display all regions in Canada,without duplicates
    List<Region> findDistinctByCountry(String country);

    // display all regions with country name includes "United"
    List<Region> findByCountryContaining(String country);

    // display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    // display top 2 regions in Canada
    List<Region> findTop2ByCountry (String country);
}
