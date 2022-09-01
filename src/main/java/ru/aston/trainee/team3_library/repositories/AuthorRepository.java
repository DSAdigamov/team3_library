package ru.aston.trainee.team3_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.trainee.team3_library.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
