package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ProductInterestRateStatus {
    DEPOSIT("Deposit"),
    DEBIT_CARD("Debit card"),
    CREDIT_CARD("Credit card");

    private final String prodInterestName;

    ProductInterestRateStatus(String prodInterestName) {
        this.prodInterestName = prodInterestName;
    }

    @Override
    public String toString() {
        return "ProductInterestRateStatus{" +
                       "prodInterestName='" + prodInterestName + '\'' +
                       '}';
    }

    public static ProductInterestRateStatus productInterestRateStatus(int code) {
        return switch (code) {
            case 1 -> DEPOSIT;
            case 2 -> DEBIT_CARD;
            case 3 -> CREDIT_CARD;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}

