package com.example.jpa.book.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpa.book.entity.Book;


@Controller
public class BookController {

    @GetMapping("/Books")
    public Book getBooks() {
        Book book = new Book(1,"Think like a monk" ,"JAY SHETTY");

        return book;
    }
    
}
