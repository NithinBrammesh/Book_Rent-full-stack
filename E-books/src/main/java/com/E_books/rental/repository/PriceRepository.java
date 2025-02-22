package com.E_books.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.E_books.rental.model.Price;
public interface PriceRepository extends JpaRepository<Price,Integer> {
}
