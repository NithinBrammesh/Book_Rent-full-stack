package com.E_books.rental.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceDto {

    private int priceId;

    private String discount;

    private int bookPrice;

}
