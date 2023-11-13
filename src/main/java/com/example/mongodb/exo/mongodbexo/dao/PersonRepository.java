package com.example.mongodb.exo.mongodbexo.dao;

import com.example.mongodb.exo.mongodbexo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
