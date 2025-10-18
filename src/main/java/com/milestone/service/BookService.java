package com.milestone.service;

import java.util.List;

import com.milestone.model.BookModel;

public interface BookService {
  List<BookModel> findAll();
  void add(BookModel book);
}
