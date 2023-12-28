package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountStatus {
    NEW(0),
    ACTIVE(1),
    BLOCKED(2);

    private final int value;

    AccountStatus(int value) {
        this.value = value;
    }
}
