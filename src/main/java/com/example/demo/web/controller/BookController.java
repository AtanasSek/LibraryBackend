package com.example.demo.web.controller;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;


@RestController
public class BookController {

    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;

        LocalDate ld = LocalDate.parse("1996-05-14");
        authorService.setAuthor("test","author",ld);
        Author author = authorService.getAuthor("test","author").get();
        bookService.save("testTitle",author, Book.Genre.fiction);
    }



    @GetMapping("/ListBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


    //Get information about a book matching this name
    @GetMapping(value="/getBook/q={bookName}")
    public ResponseEntity getBook(@PathVariable String bookName){

        return ResponseEntity.ok(bookService.getBooksByNameOnly(bookName));
    }

    @PostMapping(value = "/AddBook", consumes = "application/json")
    public ResponseEntity postBook(@RequestBody Book book){

        Author author = new Author(book.getBookId().getAuthors().getAuthorId());
        return ResponseEntity.ok(bookService.save(book.getBookId().getName(),author,book.getGenre()));
    }

    @PostMapping(value ="/DeleteBook")
    public ResponseEntity removeBook(@RequestBody Book book)
    {

        return ResponseEntity.ok(bookService.deleteBook(book.getBookId()));
    }

}
