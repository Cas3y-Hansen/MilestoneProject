package com.milestone.service;

import java.util.List;
import com.milestone.model.BookModel;

/**
 * Service interface for managing books in the library system.
 * 
 * <p>Provides methods to retrieve all books and to add new books.
 * Implementations may use in-memory storage, database access, or other mechanisms.</p>
 * 
 * author Casey
 * version 1.0
 */
public interface BookService {

    /**
     * Retrieves a list of all books in the system.
     * 
     * @return a List of BookModel objects representing all books
     */
    List<BookModel> findAll();

    /**
     * Adds a new book to the system.
     * 
     * @param book the BookModel object to add
     */
    void add(BookModel book);

    /**
     * Finds a book by its unique ID.
     *
     * @param id the ID of the book
     * @return the BookModel if found, otherwise null
     */
    BookModel findById(Long id);

    /**
     * Updates an existing book.
     *
     * @param book the updated BookModel
     * @return the saved/updated BookModel
     */
    BookModel update(BookModel book);

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     */
    void deleteById(Long id);
}
