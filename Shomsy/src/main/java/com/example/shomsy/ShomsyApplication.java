package com.example.shomsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
        ---------------------------------------------
        Shomsy
        Shopping Management System
        ---------------------------------------------
 */

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ShomsyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShomsyApplication.class, args);
    }

}
