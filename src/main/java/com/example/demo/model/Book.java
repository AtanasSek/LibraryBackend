package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @EmbeddedId
    private BookId bookId; //name and author(s)

    private String genre;

    public Book() {
    }

    public Book(String bookTitle, Author author, String genre){
        this.bookId = new BookId(bookTitle,author);
        this.genre = genre;
    }

    public String getGenre(){
        return genre;
    }

    public BookId getBookId() {
        return bookId;
    }



}
