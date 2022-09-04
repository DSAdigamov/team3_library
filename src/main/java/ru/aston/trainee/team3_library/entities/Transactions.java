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

    @ManyToMany
    @JoinTable(name = "transactions_books",
               joinColumns = @JoinColumn(name = "book_id")
               inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private List<Book> books;

    @Column(name = "total_cost")
    private double totalCost;

    @Column
    private double type;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getType() {
        return type;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setType(double type) {
        this.type = type;
    }
}