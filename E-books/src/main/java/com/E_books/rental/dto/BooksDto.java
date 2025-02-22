package com.E_books.rental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksDto {

    private int bookId;

    private String bookName;

    private String author;

    private String description;
}
