package ru.aston.trainee.team3_library.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "\"isActive\"")
    private Boolean isActive;

    @Column(name = "date_activation")
    private LocalDate dateActivation;

    @Column(name = "date_exparation")
    private LocalDate dateExparation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDate getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(LocalDate dateActivation) {
        this.dateActivation = dateActivation;
    }

    public LocalDate getDateExparation() {
        return dateExparation;
    }

    public void setDateExparation(LocalDate dateExparation) {
        this.dateExparation = dateExparation;
    }

}