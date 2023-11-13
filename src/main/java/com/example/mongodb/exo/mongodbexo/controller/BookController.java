package com.example.mongodb.exo.mongodbexo.controller;

import com.example.mongodb.exo.mongodbexo.exception.BookNotFoundException;
import com.example.mongodb.exo.mongodbexo.model.Book;
import com.example.mongodb.exo.mongodbexo.model.Genre;
import com.example.mongodb.exo.mongodbexo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService myBookService;

    @Autowired
    public BookController(BookService bookService){
        this.myBookService=bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks(){
        return this.myBookService.getAllBooks();
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        Book myBook = this.myBookService.addBook(book);
        if(Objects.isNull(myBook)){
            return ResponseEntity.noContent().build();
        }
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(myBook.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping()
    public void deleteBookByID(@PathVariable String id){
        this.myBookService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable String id){
        return this.myBookService.findByid(id).stream().findFirst();
    }

    @PutMapping()
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book){
        Book myBook = this.myBookService.updateBook(book);
        if(Objects.isNull(myBook)){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(myBook.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/pages/{nbr}")
    public List<Book> findByPagesGreaterThan(@PathVariable int nbr){
        return this.myBookService.findByPagesGreaterThan(nbr);
    }

    @GetMapping("/title/{word}")
    public List<Book> findByTitleContaining(@PathVariable String word){
        return this.myBookService.findByTitleContaining(word);
    }

    @GetMapping("/author/{word}")
    public List<Book> findByAuthorWithName(@PathVariable String word){
        List<Book> myList =  myBookService.findByAuthorWithName(word);
        if(Objects.isNull(myList) || myList.size()==0){
            throw new BookNotFoundException("Livre non trouve");
        }
        return myList;
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenre(){
        return myBookService.getALlGenre();
    }


}
