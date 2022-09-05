package ru.aston.trainee.team3_library.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@Builder
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date_of_publication")
    private LocalDate dateOfPublication;

    @Column(name = "age_allowence")
    private Integer ageAllowence;

    @Column(name = "premium")
    private Boolean premium;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "image_link")
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<User> users;
}