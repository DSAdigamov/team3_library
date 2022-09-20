package ru.aston.trainee.team3_library.dtos;

import lombok.Value;

@Value
public class AuthRequest {
    String username;

    String password;
}
