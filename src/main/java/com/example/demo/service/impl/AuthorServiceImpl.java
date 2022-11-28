package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorId;
import com.example.demo.repository.AuthorRepositoryJpa;
import com.example.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepositoryJpa authorRepositoryJpa;

    public AuthorServiceImpl(AuthorRepositoryJpa authorRepositoryJpa) {
        this.authorRepositoryJpa = authorRepositoryJpa;
    }

    public List<Author> getAllAuthors(){
        return authorRepositoryJpa.findAll();
    }

    public Optional<Author> getAuthor(String fname, String lname){
        return authorRepositoryJpa.findById(new AuthorId(fname,lname));
    }

    public List<Author> getAuthorsWithName(String name) {

        //Check if author with first name exists
        List<Author> authors = authorRepositoryJpa.findAllByAuthorId_FirstNameContaining(name);
        if(!authors.isEmpty())
            return authors;

        //Check if author with last name exists
        authors = authorRepositoryJpa.findAllByAuthorId_LastNameContaining(name);
        if(!authors.isEmpty())
            return authors;

        //Check if author has both first and last name
        if(name.split(" ").length == 2) {
            String fName = name.split(" ")[0];
            String lName = name.split(" ")[1];
            authors = authorRepositoryJpa.findAllByAuthorId_FirstNameContainingAndAuthorId_LastNameContaining(fName, lName);

            if(!authors.isEmpty())
                return authors;
        }

        //if none, return empty
        return authors;

    }

    public Author setAuthor(String fname, String lname, LocalDate dob){
        return authorRepositoryJpa.save(new Author(fname,lname,dob));
    }
}
