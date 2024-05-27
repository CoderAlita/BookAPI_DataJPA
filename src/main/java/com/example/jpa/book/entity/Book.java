package com.example.jpa.book.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Title;
    @OneToOne(cascade = CascadeType.ALL)
    private Author author;

    public Book() {
    }

    public Book(int id, Author author, String title) {
        this.id = id;
        this.author = author;
        Title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
