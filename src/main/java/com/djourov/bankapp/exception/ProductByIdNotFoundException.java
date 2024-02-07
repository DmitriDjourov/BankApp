package com.djourov.bankapp.exception;

import java.util.UUID;

public class ProductByIdNotFoundException extends RuntimeException {
    public ProductByIdNotFoundException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
