package com.example.mongodb.exo.mongodbexo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Surname {

    @Id
    private long id;
    private String surname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
