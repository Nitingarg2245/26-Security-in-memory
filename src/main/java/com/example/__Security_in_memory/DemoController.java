package com.example.__Security_in_memory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/")
    public String welcomeMsg(){
        return "welcome to our website";
    }
    @GetMapping("/hello-user")
    public String helloUser(){
        return "hello user";
    }
    @GetMapping("/hello-admin")
    public String helloAdmin(){
        return "hello admin";
    }
    @GetMapping("/info")
    public String getInfo(){
        return "site info::";
    }
    @GetMapping("/contact")
    public String getContactDetails(){
        return "Contact::0184-4092000";
    }
}
