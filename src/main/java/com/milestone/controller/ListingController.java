package com.milestone.controller;

import com.milestone.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.milestone.model.BookModel;

@Controller
public class ListingController {
  private final BookService bookService;
  public ListingController(BookService bs){ this.bookService=bs; }

@GetMapping("/allbooks")
public String getAllBooks(Model model) {
    List<BookModel> books = bookService.findAll();
    model.addAttribute("books", books);
    return "allbooks";
}

  @GetMapping("/mybooks")
  public String myBooks(Model model){
    model.addAttribute("books", bookService.findAll().stream()
      .filter(b -> !b.isAvailable()).toList());
    model.addAttribute("title","My Books");
    return "mybooks";
  }
}
