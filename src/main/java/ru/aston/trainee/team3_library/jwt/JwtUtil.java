package ru.aston.trainee.team3_library.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@Primary
public class JwtUtil {

    private Algorithm algorithm;
    @Value("${jwt.token.secret}")
    private String jwtSecret;
    @Value("${access.token.expired}")
    private Long accessTokenExpiration;
    @Value("${refresh.token.expired}")
    private Long refreshTokenExpiration;

    public String createAccessToken(UserDetails jwtUser, HttpServletRequest request) {
        algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        String accessToken = JWT.create()
                .withSubject(jwtUser.getUsername())
                .withExpiresAt(new Date(accessTokenExpiration))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", jwtUser.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .sign(algorithm);
        return accessToken;
    }

    public String createRefreshToken(UserDetails jwtUser, HttpServletRequest request) {
        algorithm = Algorithm.HMAC256(jwtSecret.getBytes());
        String refreshToken = JWT.create()
                .withSubject(jwtUser.getUsername())
                .withExpiresAt(new Date(refreshTokenExpiration))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        return refreshToken;
    }

    public String getUsernameFromToken(String currentRefreshToken) {
        algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(currentRefreshToken);
        String username = decodedJWT.getSubject();
        return username;
    }
}
