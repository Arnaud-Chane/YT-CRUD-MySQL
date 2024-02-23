package com.example.demo.controller;

import com.example.demo.model.Address;
import com.example.demo.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-addresses")
    public List<Address> getAllAddresses(){
        System.out.println(mySqlRepository.count());
        return mySqlRepository.findAll();
    }

    @GetMapping("/get-address/{identity}")
    public Address getSingleAddress(@PathVariable("identity") Integer id){
        return mySqlRepository.findById(id).get();
    }
}
