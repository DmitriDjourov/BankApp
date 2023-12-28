package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountCurrencyCode {
    EUR(1),
    USD(2),
    ILS(3),
    GBP(4),
    UAH(5),
    JPY(6);

    private final int value;

    AccountCurrencyCode(int value) {
        this.value = value;
    }
}
