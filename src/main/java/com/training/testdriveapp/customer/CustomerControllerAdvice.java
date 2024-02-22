package com.training.testdriveapp.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerControllerAdvice {
    @ExceptionHandler(value = {CustomerException.class})
    public ResponseEntity<String> accountExceptionHandler(CustomerException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}


