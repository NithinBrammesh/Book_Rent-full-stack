package com.E_books.rental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_Id")
    private int bookId;

    @Column(name="book_name")
    private String bookName;

    @Column(name="author")
    private String author;

    @Column(name="description")
    private String description;
}
