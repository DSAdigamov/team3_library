package ru.aston.trainee.team3_library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.dtos.TokenResponse;
import ru.aston.trainee.team3_library.jwt.JwtUtil;
import ru.aston.trainee.team3_library.jwt.TokenMapUtil;
import ru.aston.trainee.team3_library.services.AuthenticationService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserDetailsService jwtUserDetails;
    @Autowired
    private JwtUtil jwtUtil;

    public TokenResponse refreshTokens(HttpServletRequest request) throws IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null && header.startsWith("Bearer ")) {
            String currentRefreshToken = header.split("\\s")[1];
            UserDetails jwtUser = jwtUserDetails.loadUserByUsername(jwtUtil.getUsernameFromToken(currentRefreshToken));
            String accessToken = jwtUtil.createAccessToken(jwtUser, request);
            String refreshToken = jwtUtil.createRefreshToken(jwtUser, request);
            if (currentRefreshToken.equals(TokenMapUtil.getTokenStorageConcurrentHashMap().get(jwtUser.getUsername()))) {
                TokenMapUtil.getTokenStorageConcurrentHashMap().put(jwtUser.getUsername(), refreshToken);
                return new TokenResponse(accessToken, refreshToken);
            }
        }
        throw new UsernameNotFoundException("No such refresh token");
    }
}
