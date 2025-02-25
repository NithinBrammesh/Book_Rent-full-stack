package com.E_books.rental.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactId")
    private int transactId;

    @Column(name = "amount")
    private float amount;

    @Column(name="type")
    private String type;

    @Column(name="mode")
    private String mode;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

}
