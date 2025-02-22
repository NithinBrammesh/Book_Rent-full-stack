package com.E_books.rental.mapper;

import com.E_books.rental.dto.PriceDto;
import com.E_books.rental.model.Books;
import com.E_books.rental.model.Price;

public class PriceMapper {

    public static Price mapToPrice(PriceDto priceDto){
        Price price = new Price(
                priceDto.getPriceId(),
                priceDto.getDiscount(),
                priceDto.getBookPrice()
        );
        return price;
    }

    public static PriceDto mapToPriceDto(Price price){
        PriceDto priceDto = new PriceDto(
                price.getPriceId(),
                price.getDiscount(),
                price.getBookPrice()
                );
        return priceDto;
    }
}
