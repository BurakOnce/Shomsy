package com.example.shomsy.dtos;

import com.example.shomsy.entities.enumaration.EnumRole;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String password;
    private EnumRole userRole;

}
