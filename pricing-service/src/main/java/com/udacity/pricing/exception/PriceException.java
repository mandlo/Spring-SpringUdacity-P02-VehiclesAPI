package com.udacity.pricing.exception;

import com.udacity.pricing.domain.price.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prices")
public class PriceException extends Exception {

    public PriceException() {
    }

    public PriceException(String message) {
        super(message);
    }

    @RequestMapping("/prices")
    public String getPrice() {

        return "This is a http://localhost:8080/prices error";
    }

}
