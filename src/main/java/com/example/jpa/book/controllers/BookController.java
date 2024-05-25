package com.example.jpa.book.controllers;

import com.example.jpa.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.book.entity.Book;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> list = bookService.getBooks();
        if (list.size() <= 0)
            return ResponseEntity.notFound().build();
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable("id") int id){
        try {
            Book book =bookService.findById(id);
            return ResponseEntity.of(Optional.of(book));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }


    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book ){
        try {
            Book book1 = bookService.addBook(book);
            return ResponseEntity.of(Optional.of(book1));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @PutMapping("/books/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book ,@PathVariable("id") int id){
        try {
            bookService.update(book, id);
            return  ResponseEntity.of(Optional.of(book));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        try {
            bookService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> delete(){
        try {
            bookService.deleteAll();
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }

    }
    
}
