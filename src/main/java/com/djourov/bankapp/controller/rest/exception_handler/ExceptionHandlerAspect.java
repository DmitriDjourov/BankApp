package com.djourov.bankapp.controller.rest.exception_handler;

import com.djourov.bankapp.dto.ErrorResponse;
import com.djourov.bankapp.exception.ClientByIdNotFountException;
import com.djourov.bankapp.exception.ManagerForUpdateNotFoundException;
import com.djourov.bankapp.exception.ProductByIdNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAspect {
    @ExceptionHandler(ProductByIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductByIdNotFoundException(ProductByIdNotFoundException ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Всем стоять ровно!! Работает хендлер !!! " + ex.getMessage());
        errorResponse.setUrl(String.valueOf(request.getRequestURL()));

        return ResponseEntity
                       .status(HttpStatus.NOT_FOUND)
                       .headers(headers)
                       .body(errorResponse);
    }
    @ExceptionHandler(ClientByIdNotFountException.class)
    public ResponseEntity<ErrorResponse> handleClientByIdNotFountException(ClientByIdNotFountException ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Всем стоять ровно!! Работает хендлер !!! Неформат айпишника клиента !!!" + ex.getMessage());
        errorResponse.setUrl(String.valueOf(request.getRequestURL()));

        return ResponseEntity
                       .status(HttpStatus.NOT_FOUND)
                       .headers(headers)
                       .body(errorResponse);
    }
}
