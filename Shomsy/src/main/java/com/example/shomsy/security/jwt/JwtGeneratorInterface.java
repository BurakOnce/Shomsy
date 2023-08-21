package com.example.shomsy.security.jwt;

import com.example.shomsy.entities.User;

import java.util.Map;

public interface JwtGeneratorInterface {
    //Map<String, String> generateToken(User user);


     String generateToken(User user);

}