package com.udacity.pricing.domain.price;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.HttpStatus;
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

    private BigDecimal randomDecimal = new BigDecimal
            (BigInteger.valueOf(new Random().nextInt(100001)), 2);

    @GetMapping("/{vehicleId}")
    @ResponseStatus(code = HttpStatus.OK, reason ="VehicleId is invalid")
    public Price getPriceObject(@RequestParam Long vehicleId) {
           return new Price("USD", randomDecimal, vehicleId );
    }
}
