package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountCurrencyCode {
    EUR(0),
    USD(1),
    ILS(2),
    GBP(3),
    UAH(4),
    JPY(5);

    private final int value;

    AccountCurrencyCode(int value) {
        this.value = value;
    }
}
