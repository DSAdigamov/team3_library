package ru.aston.trainee.team3_library.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDto {

    private Long authorId;

    private String genre;

    private LocalDate dateOfPublication;

    private Integer ageAllowense;

    private Boolean premium;

    private String description;

    private String imageLink;

}
