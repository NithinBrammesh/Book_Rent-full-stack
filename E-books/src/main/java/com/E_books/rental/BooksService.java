package com.E_books.rental;

import com.E_books.rental.dto.BooksDto;

import java.util.List;

public interface BooksService {

  BooksDto createBooks(BooksDto booksDto);
  List<BooksDto> getAllBooksList();
  BooksDto getBookById(int bookId);
  BooksDto updateBook(int bookId, BooksDto booksDto);
  BooksDto deleteBookById(int bookId);
}
