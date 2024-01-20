package com.djourov.bankapp.exception;

import java.util.UUID;

public class ManagerForDeleteNotFoundException extends RuntimeException {
    public ManagerForDeleteNotFoundException(String message, UUID id) {
        super(String.format("%s: %%s".formatted(message), id));
    }
}
