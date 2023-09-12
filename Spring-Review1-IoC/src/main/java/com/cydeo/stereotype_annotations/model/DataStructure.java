package com.cydeo.stereotype_annotations.model;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataStructure {
    ExtraHours extraHours;

//@AutoWired
//    public DataStructure(ExtraHours extraHours) {
//        this.extraHours = extraHours;
//    }

    public void getTotalHours(){
        System.out.println("Total hours:" + (30 + extraHours.getHours()));
    }
}
