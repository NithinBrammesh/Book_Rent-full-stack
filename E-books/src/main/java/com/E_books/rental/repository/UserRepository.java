package com.E_books.rental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.E_books.rental.model.User;
public interface UserRepository extends JpaRepository<User,Integer> {
}
