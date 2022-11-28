package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryJpa extends JpaRepository<Book, BookId> {

    List<Book> findAllByBookId_NameContaining(String name);

}
