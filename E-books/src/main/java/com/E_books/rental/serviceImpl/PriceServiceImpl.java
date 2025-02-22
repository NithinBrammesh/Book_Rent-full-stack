package com.E_books.rental.serviceImpl;

import com.E_books.rental.PriceService;
import com.E_books.rental.dto.PriceDto;
import com.E_books.rental.mapper.PriceMapper;
import com.E_books.rental.model.Price;
import com.E_books.rental.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceDto createPrices(PriceDto priceDto){
        Price price = PriceMapper.mapToPrice(priceDto);
        Price savedPrices = priceRepository.save(price);
        return PriceMapper.mapToPriceDto(savedPrices);
    }

    @Override
    public PriceDto getPriceById(int priceId){
        Price price = priceRepository.findById(priceId).orElseThrow(()-> new RuntimeException("Price does not exist"));
        return PriceMapper.mapToPriceDto(price);
    }

    @Override
    public List<PriceDto> getAllPrices(){
        List<Price> prices = priceRepository.findAll();
        return prices.stream()
                .map(PriceMapper::mapToPriceDto)
                .collect(Collectors.toList());
    }

    @Override
    public PriceDto updatePrices(int priceId, PriceDto priceDto){
        Price existingPrice = priceRepository.findById(priceId)
                .orElseThrow(()-> new RuntimeException("Price Does not exist"));

        if(priceDto.getDiscount() != null){
            existingPrice.setBookPrice(priceDto.getBookPrice());
        }
        existingPrice.setBookPrice(priceDto.getBookPrice());

        Price updatedPrice = priceRepository.save(existingPrice);
        return new PriceDto(updatedPrice.getPriceId(), updatedPrice.getDiscount(), updatedPrice.getBookPrice());
    }

    @Override
    public PriceDto deletePriceById(int priceId){
        Price price = priceRepository.findById(priceId).orElseThrow(()-> new RuntimeException("Price Does not exist"));

        PriceDto priceDto = PriceMapper.mapToPriceDto(price);
        priceRepository.deleteById(priceId);

        return priceDto;
    }
}
