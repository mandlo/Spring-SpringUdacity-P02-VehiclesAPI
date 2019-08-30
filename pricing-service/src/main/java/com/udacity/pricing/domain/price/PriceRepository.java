package com.udacity.pricing.domain.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

@RepositoryRestResource
@RequestMapping("/prices")
public class PriceRepository {

    @Autowired
    Price price;

    @GetMapping("/{vehicleId}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Price Not Found")
    public ResponseEntity<Price> get(@RequestParam Long vehicleId) {
        BigDecimal randomDecimal = new BigDecimal
                (BigInteger.valueOf(new Random().nextInt(100001)), 2);
        return new ResponseEntity<>(new Price("USD", randomDecimal, vehicleId),
                HttpStatus.NOT_FOUND);
    }
}
