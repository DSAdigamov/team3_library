package ru.aston.trainee.team3_library.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {

    private String email;

    private String password;

    private LocalDate birthDate;

    private String firstName;

    private String lastName;

    private LocalDate registrationDate;

    private Double balance;

    private String profilePictureLink;

}
