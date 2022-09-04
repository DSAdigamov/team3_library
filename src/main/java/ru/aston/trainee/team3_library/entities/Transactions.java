package ru.aston.trainee.team3_library.entities;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_cost")
    private double totalCost;

    @Column
    private double type;

}