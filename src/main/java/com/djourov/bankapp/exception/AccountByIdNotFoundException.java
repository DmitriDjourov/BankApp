package com.djourov.bankapp.exception;

import java.util.UUID;

public class AccountByIdNotFoundException extends RuntimeException{
    public AccountByIdNotFoundException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
