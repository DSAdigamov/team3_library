package ru.aston.trainee.team3_library.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "\"isActive\"")
    private Boolean isActive;

    @Column(name = "date_activation")
    private LocalDate dateActivation;

    @Column(name = "date_exparation")
    private LocalDate dateExparation;


}