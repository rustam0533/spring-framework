package com.cydeo.stereotype_annotations;

import com.cydeo.stereotype_annotations.config.AppConfig;
import com.cydeo.stereotype_annotations.model.DataStructure;
import com.cydeo.stereotype_annotations.model.MicroServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CydeoAppRunner {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        DataStructure dataStructure = container.getBean(DataStructure.class);
        dataStructure.getTotalHours();

        MicroServices microServices = container.getBean(MicroServices.class);
        microServices.getTotalHours();

    }
}
