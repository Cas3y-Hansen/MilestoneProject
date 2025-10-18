package com.milestone.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.milestone.model.BookModel;
import com.milestone.service.BookService;

@Service
public class BookServiceImpl implements BookService {
  private final List<BookModel> books = new CopyOnWriteArrayList<>();

  public BookServiceImpl() {
    books.add(new BookModel(){{
      setTitle("Clean Code"); setAuthor("Robert C. Martin");
      setGenre("Software"); setAvailable(true);
    }});
    books.add(new BookModel(){{
      setTitle("The Pragmatic Programmer"); setAuthor("Andrew Hunt and David Thomas");
      setGenre("Software"); setAvailable(true);
    }});
  }

  @Override public List<BookModel> findAll() { return books; }
  @Override public void add(BookModel book) { books.add(book); }
}
