package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/")
    public String getHello(){
        return "Hello test";
    }


    @GetMapping("/test")
    public String getTest(){
        return "test 123456";
    }

    @GetMapping("/test2")
    public String getTest2(){
        return "test 2";
    }
    @GetMapping("/test3")
    public String getTest3(){
        return "test 3";
    }

    @GetMapping("/person")
    public Person getPerson(){
        Person p = new Person();
        p.setName("Arnaud");
        p.setAge(30);
        return p;
    }
}
