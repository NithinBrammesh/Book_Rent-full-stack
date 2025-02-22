package com.E_books.rental.mapper;

import com.E_books.rental.dto.BooksDto;
import com.E_books.rental.model.Books;

public class BooksMapper {
    public static Books mapToBooks(BooksDto booksDto){
        Books books = new Books(
                booksDto.getBookId(),
                booksDto.getAuthor(),
                booksDto.getBookName(),
                booksDto.getDescription()
        );
        return books;
    }
    public static BooksDto mapToBooksDto(Books books){
        BooksDto booksDto = new BooksDto(
                books.getBookId(),
                books.getBookName(),
                books.getAuthor(),
                books.getDescription()
        );
        return booksDto;
    }
}
