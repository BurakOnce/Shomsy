package com.example.shomsy.controllers;

import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.dtos.response.LoginResponseDTO;
import com.example.shomsy.entities.User;
import com.example.shomsy.entities.enumaration.EnumRole;
import com.example.shomsy.exceptions.UserNotFoundException;
import com.example.shomsy.services.user.UserService;
import com.example.shomsy.security.jwt.JwtGeneratorInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtGeneratorInterface jwtGenerator;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<?> postUser(@RequestBody UserDTO user){

            List<UserDTO> userList = new ArrayList<>();
            userList.add(user);

            userService.saveUser(userList);

            return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
/*
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getEmail() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Email or Password is Empty");
            }

            //Model model = new Model();

            User personData = userService.getUserByEmail(user.getEmail());
            if(personData == null || !passwordEncoder.matches(user.getPassword(), personData.getPassword())){
                throw new UserNotFoundException("Email or Password is Invalid");
            }


            return new ResponseEntity<>(jwtGenerator.generateToken(user), HttpStatus.OK);



        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Email or Password is Invalid");
        }
    }*/

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            if(user.getEmail() == null || user.getPassword() == null) {
                throw new UserNotFoundException("Email or password is empty");
            }

            User personData = userService.getUserByEmail(user.getEmail());
            if(personData == null || !passwordEncoder.matches(user.getPassword(), personData.getPassword())){
                throw new UserNotFoundException("Email or password is invalid");
            }

            String token = jwtGenerator.generateToken(user);
            EnumRole userRole = personData.getUserRole();
            String firstName = personData.getFirstName();

            LoginResponseDTO response = new LoginResponseDTO(token,firstName,userRole);

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Email or password is invalid");
        }
    }
}