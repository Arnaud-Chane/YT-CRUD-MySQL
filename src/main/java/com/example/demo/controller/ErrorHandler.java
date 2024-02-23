package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Add your custom error handling logic here
        return "error";
    }

}