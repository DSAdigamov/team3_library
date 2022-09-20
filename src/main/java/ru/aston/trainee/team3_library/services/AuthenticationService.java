package ru.aston.trainee.team3_library.services;

import org.springframework.security.core.Authentication;
import ru.aston.trainee.team3_library.dtos.AuthRequest;
import ru.aston.trainee.team3_library.dtos.TokenResponse;
import ru.aston.trainee.team3_library.jwt.JwtUser;

public interface AuthenticationService {
    JwtUser getAuthenticated(AuthRequest request);

    TokenResponse getLoginResponse(JwtUser jwtUser);

    TokenResponse getTokenResponse(JwtUser userDetails, String token);

    JwtUser getJwtUser(Authentication authentication);
}
