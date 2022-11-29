package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.BookId;

import java.util.List;
import java.util.Optional;

public interface BookService{

    List<Book> getAllBooks();
    Optional<Book> getBook(String name, Author author);
    Optional<Book> getBook(BookId bookId);
    Book save(String bookTitle, Author author, Book.Genre bookGenre);
    List<Book> getBooksByNameOnly(String name);
    boolean deleteBook(BookId bookId);


}
