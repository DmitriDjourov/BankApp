package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum TransactionTypeStatus {
    TRANSFER(0),
    PAYMENT(1),
    CASH(2),
    DEPOSIT(3);

    private final int transactionName;

    TransactionTypeStatus(int transactionName) {
        this.transactionName = transactionName;
    }

}
