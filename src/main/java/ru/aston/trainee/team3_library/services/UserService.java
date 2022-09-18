package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void deleteUserById(Long bookId);

    void createUser(User user);

    void addRoleToUser(String username, String roleName);

    User getUserByUsername(String username);

}
