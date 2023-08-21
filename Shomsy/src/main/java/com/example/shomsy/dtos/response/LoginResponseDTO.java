package com.example.shomsy.dtos.response;


import com.example.shomsy.entities.enumaration.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponseDTO {
    private String token;
    private String firstName;
    private EnumRole userRole;
}