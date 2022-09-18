package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.dtos.TokenResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface AuthenticationService {
    TokenResponse refreshTokens(HttpServletRequest request) throws IOException;
}
