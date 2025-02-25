package com.E_books.rental.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TransactionDto {

    private int transactId;
    private float amount;
    private String type;
    private String mode;
    private LocalDateTime dateTime;


}
