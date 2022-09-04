package ru.aston.trainee.team3_library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Lob
    @Column(name = "info")
    private String info;

    @Column(name = "image_small_link")
    private String imageSmallLink;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}