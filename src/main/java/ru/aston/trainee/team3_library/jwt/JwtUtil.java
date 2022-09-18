package ru.aston.trainee.team3_library.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class JwtUtil {

    private SignatureAlgorithm algorithm;
    @Value("${jwt.token.secret}")
    private String jwtSecret;
    @Value("${access.token.expired}")
    private Long accessTokenExpiration;
    @Value("${refresh.token.expired}")
    private Long refreshTokenExpiration;

    public String createAccessToken(JwtUser jwtUser) {
        List<String> roles = jwtUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .claim("id", jwtUser.getId())
                .claim("roles", roles)
                .claim("iss", "com.aston.team3library")
                .claim("sub", "com.aston.team3library")
                .compact();
    }

    public String createRefreshToken(JwtUser jwtUser) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .claim("id", jwtUser.getId())
                .claim("roles", Collections.EMPTY_LIST)
                .claim("iss", "com.aston.team3library")
                .claim("sub", "com.aston.team3library")
                .compact();
    }

    public boolean isValid(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build()
                .parseClaimsJws(token).getBody();
        Date expirationTime = claims.getExpiration();
        if (expirationTime != null && expirationTime.after(new Date())) {
            return true;
        }
        return false;
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build()
                .parseClaimsJws(token).getBody();
        return claims.get("id", Long.class);
    }

    public Collection<? extends GrantedAuthority> getAuthorities(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(jwtSecret).build()
                .parseClaimsJws(token).getBody();
        List<String> roles = claims.get("roles", List.class);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
