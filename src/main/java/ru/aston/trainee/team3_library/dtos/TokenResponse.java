package ru.aston.trainee.team3_library.dtos;

import lombok.Value;

@Value
public class TokenResponse {
    String accessToken;

    String refreshToken;
}
