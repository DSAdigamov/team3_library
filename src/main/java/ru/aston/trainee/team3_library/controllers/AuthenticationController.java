package ru.aston.trainee.team3_library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.trainee.team3_library.dtos.AuthRequest;
import ru.aston.trainee.team3_library.dtos.TokenResponse;
import ru.aston.trainee.team3_library.dtos.UserCreateDTO;
import ru.aston.trainee.team3_library.entities.User;
import ru.aston.trainee.team3_library.jwt.JwtUser;
import ru.aston.trainee.team3_library.services.AuthenticationService;
import ru.aston.trainee.team3_library.services.impl.UserServiceImpl;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/")
public class AuthenticationController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateDTO saveUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = new User(userCreateDTO.getEmail(), userCreateDTO.getUsername(), passwordEncoder.encode(userCreateDTO.getPassword()),
                userCreateDTO.getBirthDate(), userCreateDTO.getFirstName(),
                userCreateDTO.getLastName());
        userService.createUser(user);
        return userCreateDTO;
    }

    @GetMapping("/refreshtoken")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse refreshToken(Authentication authentication, @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        JwtUser jwtUser = authenticationService.getJwtUser(authentication);
        return authenticationService.getTokenResponse(jwtUser, token);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@RequestBody AuthRequest request) {
        JwtUser jwtUser = authenticationService.getAuthenticated(request);
        return authenticationService.getLoginResponse(jwtUser);
    }
}
