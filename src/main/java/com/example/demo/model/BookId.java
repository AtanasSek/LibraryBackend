package com.example.demo.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Embeddable
public class BookId implements Serializable {


    private String name;

    @ManyToOne
    private Author authors;

    //private List<Author> authorList;

    public BookId() {

    }

    public BookId(String name, Author author) {
        this.name = name;
        this.authors = author;
    }

    public String getName() {
        return name;
    }

    public Author getAuthors() {
        return authors;
    }
}
