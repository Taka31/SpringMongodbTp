package com.example.mongodb.exo.mongodbexo.dao;

import com.example.mongodb.exo.mongodbexo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    List<Book> findByPagesGreaterThan(int nbr);

    List<Book> findByTitleContaining(String word);

    @Query("SELECT b FROM Book b where b.author LIKE %:word% ")
    List<Book> findByAuthorWithName(String word);
}
