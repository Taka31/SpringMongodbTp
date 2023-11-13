package com.example.mongodb.exo.mongodbexo.dao;

import com.example.mongodb.exo.mongodbexo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
