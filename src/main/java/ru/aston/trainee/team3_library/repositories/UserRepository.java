package ru.aston.trainee.team3_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.trainee.team3_library.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
    Boolean existsByEmail(String username);
}
