package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.entities.Book;
import ru.aston.trainee.team3_library.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void deleteUserById(Long bookId);


}
