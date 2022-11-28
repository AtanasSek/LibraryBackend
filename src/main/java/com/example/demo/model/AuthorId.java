package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AuthorId implements Serializable {

    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;

    public AuthorId() {

    }

    public AuthorId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
