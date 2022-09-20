package ru.aston.trainee.team3_library.dtos;

import lombok.Data;
import ru.aston.trainee.team3_library.entities.Author;

import java.time.LocalDate;

@Data
public class BookDto {
    private Author author;

    private String genre;

    private LocalDate dateOfPublication;

    private Integer ageAllowense;

    private Boolean premium;

    private String description;

    private String imageLink;
}
