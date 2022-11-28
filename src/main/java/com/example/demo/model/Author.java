package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
public class Author {

    @EmbeddedId
    private AuthorId authorId; //fname and lastname
    private LocalDate dob;

    public Author(){

    }

    public Author(String fullname){
        this.authorId = new AuthorId(fullname.split(" ")[0],fullname.split(" ")[1]);
    }

    public Author(AuthorId authorId){
        this.authorId = authorId;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Author(String firstName, String lastName, LocalDate dob) {
        this.authorId = new AuthorId(firstName,lastName);
        this.dob = dob;
    }

    public AuthorId getAuthorId() {
        return authorId;
    }

    public LocalDate getDob() {
        return dob;
    }
}
