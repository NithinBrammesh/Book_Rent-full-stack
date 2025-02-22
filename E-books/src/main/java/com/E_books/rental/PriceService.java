package com.E_books.rental;

import com.E_books.rental.dto.PriceDto;

import java.util.List;

public interface PriceService {

    PriceDto createPrices(PriceDto priceDto);
    List<PriceDto> getAllPrices();
    PriceDto getPriceById(int priceId);
    PriceDto updatePrices(int priceId,PriceDto priceDto);
    PriceDto deletePriceById(int priceId);
}
