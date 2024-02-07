package com.djourov.bankapp.exception;

import java.util.UUID;

public class ManagerForUpdateNotFoundException extends RuntimeException {
    public ManagerForUpdateNotFoundException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
