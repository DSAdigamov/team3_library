package ru.aston.trainee.team3_library.services;

import ru.aston.trainee.team3_library.dtos.BookDto;
import ru.aston.trainee.team3_library.entities.Book;

import java.util.List;

public interface BookService {

    void createBook(BookDto bookDto);

    List<Book> getAllBooks();

    Book getBookById(Long bookId);

    List<Book> getBooksByAuthorId(Long authorId);

    void deleteBookById(Long bookId);

}
