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
}

