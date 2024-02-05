package com.djourov.bankapp.controller.rest.exception_handler;

import com.djourov.bankapp.exception.ManagerForUpdateNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAspect {
    @ExceptionHandler(ManagerForUpdateNotFoundException.class)
    public ResponseEntity<String> handleManagerForUpdateNotFoundException(ManagerForUpdateNotFoundException ex) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return ResponseEntity
                       .status(HttpStatus.NOT_FOUND)
                       .headers(headers)
                       .body("Не найден менеджер с таким айдишником !!! " + ex.getMessage());
    }

}
