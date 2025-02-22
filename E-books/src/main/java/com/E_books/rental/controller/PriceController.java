package com.E_books.rental.controller;

import com.E_books.rental.PriceService;
import com.E_books.rental.dto.PriceDto;
import com.E_books.rental.model.Price;
import com.E_books.rental.repository.PriceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/prices")
public class PriceController {

    private PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping
    public ResponseEntity<List<PriceDto>>getAllPrices(){
        return ResponseEntity.ok(priceService.getAllPrices());
    }

    @PostMapping
    public ResponseEntity<PriceDto> AddPrice(@RequestBody PriceDto priceDto){
     return new ResponseEntity<>(priceService.createPrices(priceDto), HttpStatus.CREATED);
    }

    @GetMapping("/{priceId}")
    public ResponseEntity<PriceDto> getPriceById(@PathVariable("priceId") int priceId){
        PriceDto priceDto = priceService.getPriceById(priceId);
        return ResponseEntity.ok(priceDto);
    }

    @PutMapping("/{priceId}")
    public ResponseEntity<PriceDto> updatePrices(@PathVariable int priceId, @RequestBody PriceDto priceDto){
        PriceDto updatePrice = priceService.updatePrices(priceId,priceDto);
        return ResponseEntity.ok(updatePrice);
    }

    @DeleteMapping("/{priceId}")
    public ResponseEntity<PriceDto> deletePrices(@PathVariable("priceId") int priceId){
        PriceDto deletePriceById = priceService.deletePriceById(priceId);
        return ResponseEntity.ok(deletePriceById);
    }
}
