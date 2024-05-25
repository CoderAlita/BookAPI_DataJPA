package com.example.jpa.book;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.jpa.book.entity.Book;
import com.example.jpa.book.repository.BookRepository;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(BookApplication.class, args);
		BookRepository repo = context.getBean(BookRepository.class);
		Book book = new Book();
		book.setId(0);
		book.setTitle("Think like a monk");
		book.setAuthor("JAY SHETTY");

		Book book2 =repo.save(book);

		System.out.println(book2);

		
	}


}
