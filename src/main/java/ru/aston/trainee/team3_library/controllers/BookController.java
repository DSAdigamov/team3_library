package ru.aston.trainee.team3_library.controllers;

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
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
    }

    @GetMapping
    public List<Book> getAllBooks() {
       return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("author/{authorId}")
    public List<Book> getBooksByAuthorId(@PathVariable Long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteByBookId(@PathVariable Long bookId) {
        bookService.deleteBookById(bookId);
    }

}
