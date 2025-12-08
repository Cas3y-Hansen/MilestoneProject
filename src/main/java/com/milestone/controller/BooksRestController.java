package com.milestone.controller;

import com.milestone.model.BookModel;
import com.milestone.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksRestController {

    private final BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    // REST API 1: Return all products
    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.findAll();
    }

    // REST API 2: Return a desired product
    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable Long id) {
        BookModel book = bookService.findById(id);
        
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}