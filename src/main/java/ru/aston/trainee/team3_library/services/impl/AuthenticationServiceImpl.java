package ru.aston.trainee.team3_library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.dtos.AuthRequest;
import ru.aston.trainee.team3_library.dtos.LoginResponse;
import ru.aston.trainee.team3_library.dtos.TokenResponse;
import ru.aston.trainee.team3_library.jwt.JwtUser;
import ru.aston.trainee.team3_library.jwt.JwtUtil;
import ru.aston.trainee.team3_library.services.AuthenticationService;

import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private ConcurrentHashMap<String, String> tokenStorageMap = new ConcurrentHashMap<>();

    @Override
    public TokenResponse getTokenResponse(JwtUser userDetails, String token) {
        String currentToken = tokenStorageMap.get(userDetails.getUsername());
        String accessToken = jwtUtil.createAccessToken(userDetails);
        String refreshToken = jwtUtil.createRefreshToken(userDetails);
        if (token.split("\\s")[1].equals(currentToken)) {
            tokenStorageMap.put(userDetails.getUsername(), refreshToken);
            return new TokenResponse(accessToken, refreshToken);
        }
        throw new RuntimeException("Token not found");
    }

    @Override
    public JwtUser getAuthenticated(AuthRequest request) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return (JwtUser) authenticate.getPrincipal();
    }

    @Override
    public LoginResponse getLoginResponse(JwtUser jwtUser) {
        String accessToken = jwtUtil.createAccessToken(jwtUser);
        String refreshToken = jwtUtil.createRefreshToken(jwtUser);
        tokenStorageMap.put(jwtUser.getUsername(), refreshToken);
        return new LoginResponse(accessToken, refreshToken);
    }
    @Override
    public JwtUser getJwtUser(Authentication authentication) {
        return (JwtUser) authentication.getPrincipal();
    }
}
