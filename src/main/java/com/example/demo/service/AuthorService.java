package com.example.demo.service;

import com.example.demo.model.Author;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> getAuthor(String fname, String lname);
    Author setAuthor(String fname, String lname, LocalDate dob);
    List<Author> getAllAuthors();
    List<Author> getAuthorsWithName(String name);
}
