package com.example.jpa.book;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.jpa.book.entity.Book;
import com.example.jpa.book.repository.BookRepository;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}


}
