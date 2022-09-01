package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.dtos.AuthorDto;
import ru.aston.trainee.team3_library.entities.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(AuthorDto authorDto);

    List<Author> getAllAuthors();

    Author getAuthorById(Long authorId);

    void deleteAuthorById(Long authorId);

}
