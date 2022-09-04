package ru.aston.trainee.team3_library.services.impl;

import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.entities.User;
import ru.aston.trainee.team3_library.repositories.UserRepository;
import ru.aston.trainee.team3_library.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    @Override
    public void deleteUserById(Long bookId) {
        userRepository.deleteById(bookId);
    }


}
