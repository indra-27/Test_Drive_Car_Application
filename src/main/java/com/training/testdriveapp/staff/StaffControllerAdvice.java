package com.training.testdriveapp.staff;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StaffControllerAdvice {
    @ExceptionHandler(value = {StaffException.class})
    public ResponseEntity<String> staffExceptionHandler(StaffException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
