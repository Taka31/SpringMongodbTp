package com.example.mongodb.exo.mongodbexo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Size(min=10,max=145)
    private String title;
    private String author;
    private int pages;
    private int rating;

   /* @ManyToMany
    @JoinTable(
            name = "book_genre", // Nom de la table de liaison
            joinColumns = @JoinColumn(name = "book_id"), // Colonne de clé étrangère de l'entité Many (Book)
            inverseJoinColumns = @JoinColumn(name = "genre_id") // Colonne de clé étrangère de l'entité One (Genre)
    )
    private Set<Genre> genres = new HashSet<>();*/

    public Book() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    /*public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }*/
}
