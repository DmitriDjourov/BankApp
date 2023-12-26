package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AccountTypeStatus {
    SAVINGS_ACCOUNT, //Сберегательный счет
    CURRENT_ACCOUNT, //Текущий счет
    DEPOSIT,//Временный вклад
    BUSINESS_ACCOUNT,//Бизнес-счет
    STUDENT_ACCOUNT;//Студенческий счет
}

