package com.djourov.bankapp.exception;

import java.util.UUID;

public class ManagerNotFoundException extends RuntimeException {
    public ManagerNotFoundException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
