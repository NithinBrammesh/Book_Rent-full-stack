package com.E_books.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.E_books.rental.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
