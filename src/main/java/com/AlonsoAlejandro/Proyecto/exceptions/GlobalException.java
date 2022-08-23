package com.AlonsoAlejandro.Proyecto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.AlonsoAlejandro.Proyecto.exceptions.BadRequestException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> runBadRequestError(BadRequestException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient must have an address "+ this.getClass().getName());
    }
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input field is empty, please look into it");
    }
}
