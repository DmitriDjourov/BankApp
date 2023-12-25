package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum TransactionTypeStatus {
    TRANSFER("Transfer"),
    PAYMENT("Payment"),
    CASH("Cash"),
    DEPOSIT("Deposit");

    private final String transactionName;

    TransactionTypeStatus(String transactionName) {
        this.transactionName = transactionName;
    }
    @Override
    public String toString() {
        return "TransactionTypeStatus{" +
                       "transactionName='" + transactionName + '\'' +
                       '}';
    }
    public static TransactionTypeStatus transactionTypeStatus(int code) {
        return switch (code) {
            case 1 -> TRANSFER;
            case 2 -> PAYMENT;
            case 3 -> CASH;
            case 4 -> DEPOSIT;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
