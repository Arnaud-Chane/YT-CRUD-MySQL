package com.example.demo.service;

import com.example.demo.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MySqlRepository mySqlRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = mySqlRepository.findById(id);
        if (user == null) {
            throw new UsernameNotFoundException(id);
        }
        return new User(user.getId(), user.getPassword(), new ArrayList<>());
    }
}
