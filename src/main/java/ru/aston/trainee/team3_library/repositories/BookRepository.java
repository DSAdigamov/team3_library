package ru.aston.trainee.team3_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aston.trainee.team3_library.entities.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getBookByAuthorId(Long authorId);

}
