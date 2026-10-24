package com.fitness.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {
     @NotNull(message = "Email Required")
     @Email(message = "Email Required")
    private String email;
     @NotNull(message = "Password is Required")
     @Size(min = 6)
    private String password ;
    private String firstName;
    private String lastName;


}
