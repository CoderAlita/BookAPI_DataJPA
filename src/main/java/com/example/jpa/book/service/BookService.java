package com.example.jpa.book.service;

import com.example.jpa.book.entity.Book;
import com.example.jpa.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks(){
        List<Book> list =(List<Book>) bookRepository.findAll();
        return list;
    }

    public Book findById(int id){
        Book book = bookRepository.findById(id).get();
        return book;
    }

    public Book addBook(Book book){
        Book book1 =bookRepository.save(book);
        return book1;
    }

    public  Book update(Book book, int id){
        Book book1 = bookRepository.findById(id).get();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        bookRepository.save(book1);
        return book1;
    }
    public void deleteById(int id){
        bookRepository.deleteById(id);

    }
    public  void deleteAll(){
        bookRepository.deleteAll();

    }
}
