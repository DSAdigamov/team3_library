package ru.aston.trainee.team3_library.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.trainee.team3_library.dtos.TokenResponse;
import ru.aston.trainee.team3_library.dtos.UserCreateDTO;
import ru.aston.trainee.team3_library.entities.User;
import ru.aston.trainee.team3_library.services.AuthenticationService;
import ru.aston.trainee.team3_library.services.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/")
public class AuthenticationController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreateDTO saveUser(@RequestBody UserCreateDTO userCreateDTO) {
        User user = new User(userCreateDTO.getUsername(), passwordEncoder.encode(userCreateDTO.getPassword()), userCreateDTO.getEmail());
        userService.createUser(user);
        return userCreateDTO;
    }

    @PostMapping("/refresh")
    public TokenResponse refreshTokens(HttpServletRequest request) throws IOException {
        return authenticationService.refreshTokens(request);
    }
}
