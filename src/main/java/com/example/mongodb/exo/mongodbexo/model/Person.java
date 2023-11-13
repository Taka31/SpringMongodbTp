package com.example.mongodb.exo.mongodbexo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name="id_surname")
    private Surname surname;

    @ManyToMany
    @JoinTable(
            name="Pays_Person",
            joinColumns = @JoinColumn(name="id_person"),
            inverseJoinColumns = @JoinColumn(name="id_pays")
    )
    private Set<Pays> pays=new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

    public Set<Pays> getPays() {
        return pays;
    }

    public void setPays(Set<Pays> pays) {
        this.pays = pays;
    }
}
