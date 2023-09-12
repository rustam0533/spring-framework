package com.cydeo.bean_practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SecondConfig {
//@Primary
    @Bean("string1")
    public String str1() {
        return
                "Welcome to CydeoApp";
    }
@Bean("string2")
    public String str2() {
        return
                "Spring Core Practice";
    }
}

