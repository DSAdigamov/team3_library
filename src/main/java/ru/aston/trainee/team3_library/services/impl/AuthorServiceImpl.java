package ru.aston.trainee.team3_library.services.impl;

import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.dtos.AuthorDto;
import ru.aston.trainee.team3_library.entities.Author;
import ru.aston.trainee.team3_library.repositories.AuthorRepository;
import ru.aston.trainee.team3_library.services.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(AuthorDto authorDto) {
        Author author = Author.builder()
                .firstName(authorDto.getFirstName())
                .lastName(authorDto.getLastName())
                .build();

        authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    @Override
    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
