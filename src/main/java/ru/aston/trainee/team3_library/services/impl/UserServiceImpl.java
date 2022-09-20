package ru.aston.trainee.team3_library.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ru.aston.trainee.team3_library.entities.Role;
import ru.aston.trainee.team3_library.entities.User;
import ru.aston.trainee.team3_library.repositories.RoleRepository;
import ru.aston.trainee.team3_library.repositories.UserRepository;
import ru.aston.trainee.team3_library.services.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public void deleteUserById(Long bookId) {
        userRepository.deleteById(bookId);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = getUserByUsername(username);
        Optional<Role> role = roleRepository.findByName(roleName);
        if (role.isPresent()) {
            if (user.getRoles().stream()
                    .filter(roleInArr -> roleInArr.getName().equals(role.get().getName()))
                    .findFirst().isEmpty()) {
                user.getRoles().add(role.get());
                userRepository.save(user);
            }
        }
    }
}
