package ru.aston.trainee.team3_library.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreateDTO {
    private String username;
    private String email;
    private String password;


    public UserCreateDTO(String username, String email, String password, String firstName, String lastName, LocalDate birthDate, LocalDate registrationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
