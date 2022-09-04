package ru.aston.trainee.team3_library.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Transactions> transactions;

    @ManyToMany(mappedBy = "books")
    private List<User> users;

    @Lob
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

    @Lob
    @Column(name = "image_link")
    private String imageLink;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Integer getAgeAllowence() {
        return ageAllowence;
    }

    public void setAgeAllowence(Integer ageAllowence) {
        this.ageAllowence = ageAllowence;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

}