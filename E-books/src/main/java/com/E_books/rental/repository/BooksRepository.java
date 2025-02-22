package com.E_books.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.E_books.rental.model.Books;

public interface BooksRepository extends JpaRepository<Books,Integer> {
}
