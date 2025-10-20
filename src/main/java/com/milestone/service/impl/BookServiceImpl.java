package com.milestone.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.milestone.model.BookModel;
import com.milestone.service.BookService;

/**
 * Implementation of the {@link BookService} interface that manages
 * book data in memory. This simple service maintains a thread-safe
 * list of books and allows retrieval and addition of book entries.
 *
 * <p><b>Note:</b> This is an in-memory implementation using
 * {@link CopyOnWriteArrayList} and is not connected to a database.
 * It is designed for demonstration and testing purposes.</p>
 *
 * @author Casey
 * @version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    /** Thread-safe list of books maintained in memory. */
    private final List<BookModel> books = new CopyOnWriteArrayList<>();

    /**
     * Initializes the service with a small collection of default books.
     */
    public BookServiceImpl() {
        books.add(new BookModel() {{
            setTitle("Clean Code");
            setAuthor("Robert C. Martin");
            setGenre("Software");
            setAvailable(true);
        }});
        books.add(new BookModel() {{
            setTitle("The Pragmatic Programmer");
            setAuthor("Andrew Hunt and David Thomas");
            setGenre("Software");
            setAvailable(true);
        }});
    }

    /**
     * Retrieves all books currently stored in memory.
     *
     * @return a list containing all {@link BookModel} objects
     */
    @Override
    public List<BookModel> findAll() {
        return books;
    }

    /**
     * Adds a new book to the in-memory collection.
     *
     * @param book the {@link BookModel} instance to add
     */
    @Override
    public void add(BookModel book) {
        books.add(book);
    }
}
