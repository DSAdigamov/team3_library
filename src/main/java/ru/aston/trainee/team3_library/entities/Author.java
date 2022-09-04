package ru.aston.trainee.team3_library.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Setter @Getter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
}