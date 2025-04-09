package edu.unimagdalena.aereopuerto.exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExptionHandler {
    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundExeption ex) {
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
