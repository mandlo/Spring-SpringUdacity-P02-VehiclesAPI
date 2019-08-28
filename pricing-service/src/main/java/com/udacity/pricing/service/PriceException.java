package com.udacity.pricing.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK, reason = "Price not found")
public class PriceException extends Exception {

    public PriceException() {
    }

    public PriceException(String message) {
        super(message);
    }
}
