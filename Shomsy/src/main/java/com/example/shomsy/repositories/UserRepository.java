package com.example.shomsy.repositories;

import com.example.shomsy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import javax.swing.event.ListDataEvent;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByAge(int a);
    List<User> findByAgeGreaterThan(int a);
    List<User> findByAgeLessThan(int a);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findByEmail(String lastName);

    Boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u FROM User u WHERE u.age > :age AND LENGTH(u.lastName) > :lastNameLength")
    List<User> findUsersWithAgeGreaterThanAndLastNameLengthGreaterThan(int age, int lastNameLength);

}
