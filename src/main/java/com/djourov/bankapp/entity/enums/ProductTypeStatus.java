package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ProductTypeStatus {
    DEPOSIT("Deposit"),
    DEBIT_CARD("Debit card"),
    CREDIT_CARD("Credit card");

    private final String productName;

    ProductTypeStatus(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ProductTypeStatus{" +
                       "productName='" + productName + '\'' +
                       '}';
    }

    public static ProductTypeStatus productTypeStatus(int code) {
        return switch (code) {
            case 1 -> DEPOSIT;
            case 2 -> DEBIT_CARD;
            case 3 -> CREDIT_CARD;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}