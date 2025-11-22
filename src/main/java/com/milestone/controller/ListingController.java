package com.milestone.controller;

import com.milestone.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import java.util.List;
import com.milestone.model.BookModel;
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53

@Controller
public class ListingController {
  private final BookService bookService;
  public ListingController(BookService bs){ this.bookService=bs; }

<<<<<<< HEAD
  @GetMapping("/allbooks")
  public String allBooks(Model model){
    model.addAttribute("books", bookService.findAll());
    model.addAttribute("title","All Books");
    return "allbooks";
  }
=======
@GetMapping("/allbooks")
public String getAllBooks(Model model) {
    List<BookModel> books = bookService.findAll();
    model.addAttribute("books", books);
    return "allbooks";
}
>>>>>>> 89d1c399dd32c88b3f4aaa71c221fd83192f6e53

  @GetMapping("/mybooks")
  public String myBooks(Model model){
    model.addAttribute("books", bookService.findAll().stream()
      .filter(b -> !b.isAvailable()).toList());
    model.addAttribute("title","My Books");
    return "mybooks";
  }
}
