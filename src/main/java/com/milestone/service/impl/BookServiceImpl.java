package com.milestone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milestone.model.BookModel;
import com.milestone.repository.BookRepository;
import com.milestone.service.BookService;

/**
 * Implementation of the {@link BookService} interface that manages
 * book data in a database using Spring Data JPA.
 *
 * <p>This service provides methods to retrieve and add books via
 * the {@link BookRepository} interface, which communicates with
 * the underlying database.</p>
 *
 * <p><b>Note:</b> This replaces the previous in-memory implementation
 * with a persistent data layer while preserving the same structure
 * and logic flow.</p>
 * 
 * @author Casey
 * @version 2.0
 */
@Service
public class BookServiceImpl implements BookService {

    /** Repository interface for performing CRUD operations on Book entities. */
    private final BookRepository bookRepository;

    /**
     * Constructs the BookServiceImpl with an injected BookRepository.
     * Adds initial demo books if the database is empty.
     */
    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

        // Initialize demo books only if DB is empty
        if (bookRepository.count() == 0) {
            BookModel book1 = new BookModel(null, "Clean Code", "Robert C. Martin", "Software", true);
            BookModel book2 = new BookModel(null, "The Pragmatic Programmer", "Andrew Hunt and David Thomas", "Software", true);
            bookRepository.save(book1);
            bookRepository.save(book2);
        }
    }

    /**
     * Retrieves all books from the database.
     *
     * @return a list containing all {@link BookModel} objects
     */
    @Override
    public List<BookModel> findAll() {
        List<BookModel> books = new java.util.ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    /**
     * Adds a new book record to the database.
     *
     * @param book the {@link BookModel} instance to add
     */
    @Override
    public void add(BookModel book) {
        bookRepository.save(book);
    }
}
