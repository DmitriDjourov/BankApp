package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountCurrencyCode {
    EUR("Euro"),
    USD("US Dollar"),
    ILS("New Israeli Sheqel"),
    GBP("Pound Sterling"),
    UAH("Hryvnia"),
    JPY("Yen");

    private final String currencyName;
    AccountCurrencyCode(String currencyName) {
        this.currencyName = currencyName;
    }
        @Override
        public String toString () {
            return this.name();
        }
        public static AccountCurrencyCode accountCurrencyCode(int code) {
        return switch (code) {
            case 1 -> EUR;
            case 2 -> USD;
            case 3 -> ILS;
            case 4 -> UAH;
            case 5 -> JPY;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
