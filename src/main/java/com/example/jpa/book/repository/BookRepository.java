package com.example.jpa.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.book.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer>{

    
}
