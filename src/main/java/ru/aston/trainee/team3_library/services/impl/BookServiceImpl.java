package ru.aston.trainee.team3_library.services.impl;

import org.springframework.stereotype.Service;
import ru.aston.trainee.team3_library.dtos.BookDto;
import ru.aston.trainee.team3_library.entities.Book;
import ru.aston.trainee.team3_library.repositories.BookRepository;
import ru.aston.trainee.team3_library.services.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void createBook(BookDto bookDto) {
        Book book = Book.builder()
                .authorId(bookDto.getAuthorId())
                .genre(bookDto.getGenre())
                .dateOfPublication(bookDto.getDateOfPublication())
                .ageAllowence(bookDto.getAgeAllowense())
                .premium(bookDto.getPremium())
                .description(bookDto.getDescription())
                .imageLink(bookDto.getImageLink())
                .build();

        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow();
    }

    @Override
    public List<Book> getBooksByAuthorId(Long authorId) {
        return bookRepository.getBookByAuthorId(authorId);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

}