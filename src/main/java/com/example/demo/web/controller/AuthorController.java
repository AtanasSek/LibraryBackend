package com.example.demo.web.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/AddAuthor")
    public ResponseEntity postAuthor(@RequestBody Author author){

        return ResponseEntity.ok(authorService.setAuthor(author.getAuthorId().getFirstName(),author.getAuthorId().getLastName(),author.getDob()));
    }

    //For testing
    @GetMapping("/ListAuthors")
    public ResponseEntity getAllAuthors(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/GetAuthor/q={authorName}")
    public ResponseEntity getAuthor(@PathVariable String authorName){

        return ResponseEntity.ok(authorService.getAuthorsWithName(authorName));

    }
}
