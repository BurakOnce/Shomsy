package com.example.shomsy.services.user;

import java.util.List;

import com.example.shomsy.dtos.UserDTO;
import com.example.shomsy.entities.User;
import com.example.shomsy.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface UserService {
    void saveUser(List<UserDTO> dto);
    void updateUser(List<UserDTO> dto);
    void deleteUser(List<UserDTO> dto);
    void deleteAllUsers();
    Long countUsers();
    List<User> getAllUsers();
    User getOneUser(Long id);
    List<User> findUsersByFirstName(String keyword);
    List<User> findUsersByLastName(String keyword);
    List<User> findUsersByDesiredAge(int age);
    List<User> findUsersByYoungerThenDesiredAge(int age);
    List<User> findUsersByOlderThenDesiredAge(int age);
    List<User> sortAscUsersByAge();
    List<User> sortDescUsersByAge();
    User getUserByEmail(String email);

    /*
    public Person getPersonByEmailAndPassword(String email, String password) throws UserNotFoundException;
    boolean isPasswordMatch(Person person, String password);
    */
}
