package com.djourov.bankapp.controller.rest.exception_handler;

import com.djourov.bankapp.dto.ErrorResponse;
import com.djourov.bankapp.exception.ClientByIdNotFountException;
import com.djourov.bankapp.exception.ProductByIdNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Handle product by ID not found exception",
            description = "This method handles the exception when a product by ID is not found.",
            tags = "ExceptionHandlerAspect",
            responses = {
                    @ApiResponse(responseCode = "404", description = "Product by ID is not found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)))
            })
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
    @Operation(summary = "Handle client by ID not found exception",
            description = "This method handles the exception when a client by ID is not found.",
            tags = "ExceptionHandlerAspect",
            responses = {
                    @ApiResponse(responseCode = "404", description = "Client by ID is not found",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorResponse.class)))
            })
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
