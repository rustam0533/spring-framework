package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // Annotate the class with @Controller stereotype annotation
public class HomeController {
    @RequestMapping("/home")  //use @RequestMapping annotation to associate the action with a HTTP request path
    public String home() {
        return "home.html";   // return the HTML document name that contains the details we want the browser to display
    }
        @RequestMapping("/welcome")
        public String home2() {
            return "welcome.html";
        }



}
