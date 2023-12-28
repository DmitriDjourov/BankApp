package com.djourov.bankapp.entity.enums;

public enum ProductName {
    DEPOSIT("Deposit"),
    DEBIT_CARD("Debit card"),
    CREDIT_CARD("Credit card");

    private final String productName;

    ProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "ProductName{" +
                       "productName='" + productName + '\'' +
                       '}';
    }
}
