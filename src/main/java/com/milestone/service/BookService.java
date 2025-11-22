package com.milestone.service;

import java.util.List;
import com.milestone.model.BookModel;

/**
 * Service interface for managing books in the library system.
 * 
 * <p>Provides methods to retrieve all books and to add new books.
 * Implementations may use in-memory storage, database access, or other mechanisms.</p>
 * 
 * @author Casey
 * @version 1.0
 */
public interface BookService {

    /**
     * Retrieves a list of all books in the system.
     * 
     * @return a {@link List} of {@link BookModel} objects representing all books
     */
    List<BookModel> findAll();

    /**
     * Adds a new book to the system.
     * 
     * @param book the {@link BookModel} object to add
     */
    void add(BookModel book);
    
    BookModel findById(Long id);

    BookModel update(BookModel book);

    void deleteById(Long id);
<<<<<<< HEAD
}
=======
}
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53
