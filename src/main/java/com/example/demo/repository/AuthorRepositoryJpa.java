package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorId;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepositoryJpa extends JpaRepository<Author, AuthorId> {

    List<Author> findAllByAuthorId_FirstNameContaining(String firstName);
    List<Author> findAllByAuthorId_LastNameContaining(String lastName);
    List<Author> findAllByAuthorId_FirstNameContainingAndAuthorId_LastNameContaining(String firstName,String lastName);
}
