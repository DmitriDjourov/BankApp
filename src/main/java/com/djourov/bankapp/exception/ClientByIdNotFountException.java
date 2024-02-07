package com.djourov.bankapp.exception;

import java.util.UUID;

public class ClientByIdNotFountException extends RuntimeException{
    public ClientByIdNotFountException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
