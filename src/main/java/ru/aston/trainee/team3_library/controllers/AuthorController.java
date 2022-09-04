package ru.aston.trainee.team3_library.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.aston.trainee.team3_library.dtos.AuthorDto;
import ru.aston.trainee.team3_library.entities.Author;
import ru.aston.trainee.team3_library.services.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    public final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('MODERATOR')")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('MODERATOR')")
    public Author getAuthorById(@PathVariable Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @DeleteMapping("/{authorId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteAuthorById(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
    }

}
