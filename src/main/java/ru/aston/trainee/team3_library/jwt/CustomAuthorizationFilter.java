package ru.aston.trainee.team3_library.jwt;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final JwtUserDetails userDetailsService;

    private static Logger log = LoggerFactory.getLogger(CustomAuthorizationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .filter(t -> t.startsWith("Bearer "))
                .map(t -> t.substring("Bearer ".length())).orElse("");
        Optional.of(token)
                .filter(t -> !t.equals(""))
                .filter(jwtUtil::isValid)
                .map(jwtUtil::getUserId)
                .map(userDetailsService::loadUserByUserId)
                .map(jwtUser -> new UsernamePasswordAuthenticationToken(jwtUser, "", jwtUtil.getAuthorities(token)))
                .ifPresent(authenticationToken -> SecurityContextHolder.getContext().setAuthentication(authenticationToken));
        filterChain.doFilter(request, response);
    }

}
