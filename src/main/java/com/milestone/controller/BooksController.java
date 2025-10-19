package com.milestone.controller;

import com.milestone.model.BookModel;
import com.milestone.service.BookService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BooksController {
  private final BookService bookService;
  public BooksController(BookService bookService){ this.bookService = bookService; }

  @GetMapping("/add")
  public String addForm(Model model){
    model.addAttribute("bookModel", new BookModel());
    model.addAttribute("title","Add Book");
    return "addbook";
  }

  @PostMapping("/save")
  public String save(@Valid @ModelAttribute("bookModel") BookModel book,
                     BindingResult binding, RedirectAttributes ra) {
    if (binding.hasErrors()) return "addbook";
    bookService.add(book);
    ra.addFlashAttribute("message","Book saved: " + book.getTitle());
    return "redirect:/allbooks";
  }
}
