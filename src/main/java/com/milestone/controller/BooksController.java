package com.milestone.controller;

import com.milestone.model.BookModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for managing book-related endpoints
 */
@Controller
public class BooksController {

    /**
     * Displays the user's personal book collection
     * @param model the model to hold view data
     * @return the mybooks view template
     */
    @GetMapping("/mybooks")
    public String myBooks(Model model) {

        List<BookModel> books = new ArrayList<>();
        books.add(new BookModel(1L, "1984", "George Orwell", "Dystopian", false));
        books.add(new BookModel(2L, "To Kill a Mockingbird", "Harper Lee", "Classic", false));

        model.addAttribute("title", "My Books");
        model.addAttribute("books", books);

        return "mybooks";
    }

    /**
     * Displays all available books in the library
     * @param model the model to hold view data
     * @return the allbooks view template
     */
    @GetMapping("/allbooks")
    public String allBooks(Model model) {

        List<BookModel> books = new ArrayList<>();
        books.add(new BookModel(1L, "1984", "George Orwell", "Dystopian", true));
        books.add(new BookModel(2L, "To Kill a Mockingbird", "Harper Lee", "Classic", true));
        books.add(new BookModel(3L, "The Hobbit", "J.R.R. Tolkien", "Fantasy", true));
        books.add(new BookModel(4L, "Clean Code", "Robert C. Martin", "Programming", true));

        model.addAttribute("title", "All Books");
        model.addAttribute("books", books);

        return "allbooks";
    }
}
