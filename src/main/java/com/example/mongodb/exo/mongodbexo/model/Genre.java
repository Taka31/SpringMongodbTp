package com.example.mongodb.exo.mongodbexo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(
            name="book_genre",
            joinColumns=@JoinColumn(name="genre_id"),
            inverseJoinColumns = @JoinColumn(name="book_id")
    )
    Set<Book> books= new HashSet<Book>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
