package ru.aston.trainee.team3_library.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.aston.trainee.team3_library.dtos.BookDto;
import ru.aston.trainee.team3_library.entities.Book;
import ru.aston.trainee.team3_library.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODERATOR')")
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('MODERATOR')")
    public List<Book> getAllBooks() {
       return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('MODERATOR')")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("author/{authorId}")
    @PreAuthorize("hasRole('USER') || hasRole('ADMIN') || hasRole('MODERATOR')")
    public List<Book> getBooksByAuthorId(@PathVariable Long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODERATOR')")
    public void deleteByBookId(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }

}
