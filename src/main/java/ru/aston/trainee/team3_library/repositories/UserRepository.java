package ru.aston.trainee.team3_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.trainee.team3_library.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
