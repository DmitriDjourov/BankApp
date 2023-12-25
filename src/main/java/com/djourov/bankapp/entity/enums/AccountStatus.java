package com.djourov.bankapp.entity.enums;

import lombok.Getter;
@Getter
public enum AccountStatus {
    NEW,
    ACTIVE,
    BLOCKED;
    public static AccountStatus accountStatus(int code) {
        return switch (code) {
            case 1 -> NEW;
            case 2 -> ACTIVE;
            case 3 -> BLOCKED;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
