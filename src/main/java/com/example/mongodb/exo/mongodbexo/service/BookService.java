package com.example.mongodb.exo.mongodbexo.service;

import com.example.mongodb.exo.mongodbexo.dao.BookRepository;
import com.example.mongodb.exo.mongodbexo.dao.GenreRepository;
import com.example.mongodb.exo.mongodbexo.model.Book;
import com.example.mongodb.exo.mongodbexo.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    BookRepository myRepo;
    GenreRepository myGenre;

    @Autowired
    public BookService(BookRepository bookRepository, GenreRepository genreRepository) {
        this.myRepo = bookRepository;
        this.myGenre=genreRepository;
    }

    public List<Book> getAllBooks() {
        return myRepo.findAll();
    }

    public Book addBook(Book book){
        return myRepo.save(book);
    }

    public void deleteBook(String id){
        myRepo.deleteById(id);
    }

    public Optional<Book> findByid(String id){
        return myRepo.findById(id);
    }

    public Book updateBook(Book book){
       return  myRepo.save(book);
    }

    public List<Book> findByPagesGreaterThan(int nbr){
        return myRepo.findByPagesGreaterThan(nbr);
    }

    public List<Book> findByTitleContaining(String word){
        return myRepo.findByTitleContaining(word);
    }

    public List<Book> findByAuthorWithName(String word){
        return myRepo.findByAuthorWithName(word);
    }

    public List<Genre> getALlGenre(){
        return myGenre.findAll();
    }

}
