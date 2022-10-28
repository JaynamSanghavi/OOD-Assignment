package com.example.reusebook.Service;

import com.example.reusebook.Model.Price;
import com.example.reusebook.Repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public ResponseEntity<List<Price>> getAllPricesByBookId(Long bookId) {
        List<Price> prices = priceRepository.findByBookId(bookId);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    public ResponseEntity<Price> getPriceByBookId(Long bookId) {
        Price prices = priceRepository.findByBookIdOrderByLevelDesc(bookId);
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    public ResponseEntity<Price> updatePrice(long priceId, Price priceR) {
        Price price = priceRepository.findById(priceId).orElseThrow();
        price.setPrice(priceR.getPrice());
        return new ResponseEntity<>(priceRepository.save(price), HttpStatus.OK);
    }
}
