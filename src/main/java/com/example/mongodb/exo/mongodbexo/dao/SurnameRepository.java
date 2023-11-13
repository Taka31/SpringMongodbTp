package com.example.mongodb.exo.mongodbexo.dao;

import com.example.mongodb.exo.mongodbexo.model.Surname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurnameRepository extends JpaRepository<Surname,Long> {
}
