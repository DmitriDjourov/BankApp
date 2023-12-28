package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    ACTIVE(0),
    NOT_ACTIVE(1);

    private final int value;

    ProductStatus(int value) {
        this.value = value;
    }
}