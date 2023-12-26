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
}
