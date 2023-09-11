package com.cydeo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCar {
    @Bean
    Car car() {
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    /*
@Bean
    Person person(){
    Person p = new Person();
    p.setName("Mike");
    p.setCar(car());  //direct wiring => calling one method into another method
    return p;
}
}*/

// Autowiring
@Bean
Person person(Car car){
        Person p = new Person();
        p.setName("Mike");
        p.setCar(car);
        return p;


}
    }