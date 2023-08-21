package com.example.shomsy.controllers;


import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.entities.User;
import com.example.shomsy.services.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    private UserServiceImpl userService;


    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/User/PostUser")
    ResponseEntity<String> saveUser(@RequestBody List<UserDTO> dtos) {
        userService.saveUser(dtos);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("saved all Users");
    }
    @GetMapping   ("/User")
    List<User> getAllUsers() {return userService.getAllUsers();}

    @PostMapping("/User/UpdateUser")
    void updateUser(@RequestBody List<UserDTO> dtos) {userService.updateUser(dtos);}

    @DeleteMapping("/User/DeleteUser")
    void deleteUser(@RequestBody List<UserDTO> dtos) { userService.deleteUser(dtos);}

    @DeleteMapping   ("/User/DeleteAllUsers")
    ResponseEntity<String> deleteAllUsers() { userService.deleteAllUsers();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("deleted all Users");}

    @GetMapping("/User/CountUsers")
    Long countUsers() {return userService.countUsers();}

    @GetMapping   ("/User/GetOneUser")
    User getOneUser(@RequestParam Long id) {return userService.getOneUser(id);}

    @GetMapping   ("/User/FindUsersByFirstName")
    List<User> findUsersByFirstName(String firstName){return userService.findUsersByFirstName(firstName);};

    @GetMapping   ("/User/FindUsersByLastName")
    List<User> findUsersByLastName(String lastName){return userService.findUsersByLastName(lastName);};

    @GetMapping   ("/User/FindUsersByDesiredAge")
    List<User> findUsersByDesiredAge(int age){return userService.findUsersByDesiredAge(age);};

    @GetMapping   ("/User/FindUsersByYoungerThenDesiredAge")
    List<User> findUsersByYoungerThenDesiredAge(int age){return userService.findUsersByYoungerThenDesiredAge(age);};

    @GetMapping   ("/User/FindUsersByOlderThenDesiredAge")
    List<User> findUsersByOlderThenDesiredAge(int age){return userService.findUsersByOlderThenDesiredAge(age);};

    @GetMapping   ("/User/SortAscUsersByAge")
    List<User> sortAscUsersByAge(){return userService.sortAscUsersByAge();};

    @GetMapping   ("/User/SortDescUsersByAge")
    List<User> sortDescUsersByAge(){return userService.sortDescUsersByAge();};



}

