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
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int userId;

    @Column(name = "Phone_no", unique = true)
    private Long phoneNo;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;


}
