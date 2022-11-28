package com.example.demo.service.impl;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.BookId;
import com.example.demo.repository.BookRepositoryJpa;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryJpa bookRepositoryJpa;

    public BookServiceImpl(BookRepositoryJpa bookRepositoryJpa) {
        this.bookRepositoryJpa = bookRepositoryJpa;
    }

    public List<Book> getAllBooks(){
        return this.bookRepositoryJpa.findAll();
    }

    public Optional<Book> getBook(String name, Author author) {
        return this.bookRepositoryJpa.findById(new BookId(name,author));
    }

    public Optional<Book> getBook(BookId bookId) {
        return this.bookRepositoryJpa.findById(bookId);
    }

    public List<Book> getBooksByNameOnly(String name){
        return this.bookRepositoryJpa.findAllByBookId_NameContaining(name);
    }

    public boolean deleteBook(BookId bookId){
        try{
            this.bookRepositoryJpa.deleteById(bookId);
            return true;
        }
        catch (Exception err){
            System.out.println(err);
        }
        return false;
    }

    public Book save(String bookTitle, Author author, String bookGenre) {
        return this.bookRepositoryJpa.save(new Book(bookTitle, author, bookGenre));
    }
}
