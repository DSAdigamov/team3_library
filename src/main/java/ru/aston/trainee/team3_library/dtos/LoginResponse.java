package ru.aston.trainee.team3_library.dtos;

import lombok.Value;

@Value
public class LoginResponse {
    String accessToken;
    String refreshToken;
}
