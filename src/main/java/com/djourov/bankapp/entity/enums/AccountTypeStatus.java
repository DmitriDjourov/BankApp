package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountTypeStatus {
    SAVINGS_ACCOUNT, //Сберегательный счет
    CURRENT_ACCOUNT, //Текущий счет
    DEPOSIT,//Временный вклад
    BUSINESS_ACCOUNT,//Бизнес-счет
    STUDENT_ACCOUNT;//Студенческий счет

    public static AccountTypeStatus accountTypeStatus(int code) {
        return switch (code) {
            case 1 -> SAVINGS_ACCOUNT;
            case 2 -> CURRENT_ACCOUNT;
            case 3 -> DEPOSIT;
            case 4 -> BUSINESS_ACCOUNT;
            case 5 -> STUDENT_ACCOUNT;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}

