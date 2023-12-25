package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ClientStatus {
    ACTIVE,// Клиент активно использует банковские услуги
    FROZEN,//Действие счета или услуги клиента временно приостановлено
    OVERDUE,//Клиент имеет просроченные платежи или задолженность перед банком.
    PRIVILEGED,//Клиент имеет особые привилегии или статус
    CLOSED;//Клиент закрыл свой счет
    public static ClientStatus clientStatus(int code) {
        return switch (code) {
            case 1 -> ACTIVE;
            case 2 -> FROZEN;
            case 3 -> OVERDUE;
            case 4 -> PRIVILEGED;
            case 5 -> CLOSED;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
