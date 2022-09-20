package ru.aston.trainee.team3_library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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