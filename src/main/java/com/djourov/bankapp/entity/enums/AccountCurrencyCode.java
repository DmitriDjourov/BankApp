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
    public String toString() {
        return "AccountCurrencyCode{" +
                       "currencyName='" + currencyName + '\'' +
                       '}';
    }
}
