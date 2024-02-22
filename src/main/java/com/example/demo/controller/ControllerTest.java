package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @GetMapping("/")
    public String getHello(){
        return "Hello test";
    }


    @GetMapping("/test")
    public String getTest(){
        return "test 1";
    }

    @GetMapping("/test2")
    public String getTest2(){
        return "test 2";
    }
    @GetMapping("/test3")
    public String getTest3(){
        return "test 3";
    }
}
