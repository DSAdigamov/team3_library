package ru.aston.trainee.team3_library.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "username")
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @CreatedDate
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "profile_picture_link")
    private String profilePictureLink;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @ManyToMany
    @JoinTable(name = "users_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}