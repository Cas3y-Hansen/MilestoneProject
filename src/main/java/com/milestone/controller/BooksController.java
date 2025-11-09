package com.milestone.controller;

import com.milestone.model.BookModel;
import com.milestone.service.BookService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller class responsible for handling all web requests related to Book operations.
 * Provides routes for creating, viewing, editing, updating, and deleting book records.
 * 
 * <p>Uses Spring MVC annotations for routing and integrates with {@link BookService}
 * for the business logic layer.</p>
 * 
 * <p>Base path: <b>/books</b></p>
 */
@Controller
@RequestMapping("/books")
public class BooksController {

    /** Service layer dependency for managing book operations. */
    private final BookService bookService;

    /**
     * Constructor-based dependency injection of the {@link BookService}.
     *
     * @param bookService the service used to interact with the data layer
     */
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Displays the form for adding a new book.
     *
     * @param model the model used to pass data to the view
     * @return the name of the Thymeleaf template for adding a book
     */
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("bookModel", new BookModel());
        model.addAttribute("title", "Add Book");
        return "addbook";
    }

    /**
     * Handles submission of the new book form and saves the book to the database.
     *
     * @param book the {@link BookModel} object populated from the form
     * @param binding contains validation results for the form fields
     * @param ra used to add flash messages for redirection
     * @return redirect to the list of all books upon success, or reloads the form on validation error
     */
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("bookModel") BookModel book,
                       BindingResult binding,
                       RedirectAttributes ra) {
        if (binding.hasErrors()) return "addbook";
        bookService.add(book);
        ra.addFlashAttribute("message", "Book saved: " + book.getTitle());
        return "redirect:/allbooks";
    }

    /**
     * Displays details of a specific book by ID.
     *
     * @param id the unique identifier of the book
     * @param model the model used to pass the book data to the view
     * @return the book detail page or redirects to the list page if the book is not found
     */
    @GetMapping("/{id}")
    public String viewBook(@PathVariable("id") Long id, Model model) {
        BookModel book = bookService.findById(id);
        if (book == null) {
            return "redirect:/allbooks";
        }
        model.addAttribute("book", book);
        model.addAttribute("title", "Book Details");
        return "bookdetail";
    }

    /**
     * Displays the edit form for a specific book by ID.
     *
     * @param id the unique identifier of the book to edit
     * @param model the model used to pass data to the view
     * @return the edit page for the selected book, or redirects to list if not found
     */
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        BookModel book = bookService.findById(id);
        if (book == null) {
            return "redirect:/allbooks";
        }
        model.addAttribute("bookModel", book);
        model.addAttribute("title", "Edit Book");
        return "editbook";
    }

    /**
     * Handles submission of the edit form to update an existing book record.
     *
     * @param book the updated {@link BookModel} object
     * @param binding contains validation results for the form fields
     * @param ra used to add flash messages for redirection
     * @return redirect to the list of all books upon success, or reloads the form on validation error
     */
    @PostMapping("/update")
    public String updateBook(@Valid @ModelAttribute("bookModel") BookModel book,
                             BindingResult binding,
                             RedirectAttributes ra) {
        if (binding.hasErrors()) {
            return "editbook";
        }
        bookService.update(book);
        ra.addFlashAttribute("message", "Book updated: " + book.getTitle());
        return "redirect:/allbooks";
    }

    /**
     * Deletes a specific book by ID.
     *
     * @param id the unique identifier of the book to delete
     * @param ra used to add flash messages for redirection
     * @return redirect to the list of all books after deletion
     */
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id,
                             RedirectAttributes ra) {
        bookService.deleteById(id);
        ra.addFlashAttribute("message", "Book deleted (ID: " + id + ")");
        return "redirect:/allbooks";
    }
}
