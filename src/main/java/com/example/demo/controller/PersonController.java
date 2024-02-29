package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/")
    public String home() {
        return
                "<html>\n" +
                        "  <head>\n" +
                        "    <title>Home</title>\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "    <p>\n" +
                        "      <a href=\"http://localhost:8080/users\">Users</a>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "      <a href=\"http://localhost:8080/admins\">Admins</a>\n" +
                        "    </p>\n" +
                        "    <p>\n" +
                        "      <a href=\"http://localhost:8080/logout\">Log out</a>\n" +
                        "    </p>\n" +
                        "  </body>\n" +
                        "</html>\n";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "Only users can see this";
    }

    @GetMapping("/admins")
    public String getAdmins() {
        return "Only admins can see this";
    }

    @GetMapping("/test")
    public String getTest() {
        return "test 123456";
    }

    @GetMapping("/test2")
    public String getTest2() {
        return "test 2";
    }

    @GetMapping("/test3")
    public String getTest3() {
        return "test 3";
    }

    @GetMapping("/person")
    public Person getPerson() {
        Person p = new Person();
        p.setName("Arnaud");
        p.setAge(30);
        return p;
    }

    @GetMapping("/endpoint")
    public String endpoint() {
        return "endpoint";
    }
}
