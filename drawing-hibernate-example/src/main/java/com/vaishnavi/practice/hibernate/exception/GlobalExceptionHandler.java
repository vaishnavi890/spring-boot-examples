package com.vaishnavi.practice.hibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = DrawingNotFoundException.class)
    public ResponseEntity<Object> handleDrawingNotFound(DrawingNotFoundException ex) {
        return new ResponseEntity<>("Drawing not found.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



