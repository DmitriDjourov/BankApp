package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountTypeStatus {
    SAVINGS_ACCOUNT(0), //Сберегательный счет
    CURRENT_ACCOUNT(1), //Текущий счет
    DEPOSIT(2),//Временный вклад
    BUSINESS_ACCOUNT(3),//Бизнес-счет
    STUDENT_ACCOUNT(4);//Студенческий счет

    private final int value;

    AccountTypeStatus(int value) {
        this.value = value;
    }
}

