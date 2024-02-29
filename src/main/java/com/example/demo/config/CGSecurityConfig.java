package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class CGSecurityConfig extends SecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/login").permitAll() // permit everyone to access login
                .anyRequest().authenticated() // all other requests need authentication
                .and()
                .formLogin()
                .loginProcessingUrl("/login") // the URL on which the clients should post the login information
                .usernameParameter("id") // the name of the username parameter in the LoginForm
                .passwordParameter("password"); // the name of the password parameter in the LoginForm
    }
}
