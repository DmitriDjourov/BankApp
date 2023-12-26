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
}