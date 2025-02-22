package com.E_books.rental.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="priceId")
    private int priceId;

    @Column(name="discount")
    private String discount;

    @Column(name="book_price")
    private int bookPrice;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "bookId", referencedColumnName = "book_Id")
//    @JsonBackReference
//    private Books books;
}
