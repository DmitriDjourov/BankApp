package com.djourov.bankapp.exception;

import java.util.UUID;

public class ClientNotFountException extends RuntimeException{
    public ClientNotFountException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
