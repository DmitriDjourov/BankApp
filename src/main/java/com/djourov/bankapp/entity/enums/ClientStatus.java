package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ClientStatus {
    ACTIVE(0),// Клиент активно использует банковские услуги
    FROZEN(1),//Действие счета или услуги клиента временно приостановлено
    OVERDUE(2),//Клиент имеет просроченные платежи или задолженность перед банком.
    PRIVILEGED(3),//Клиент имеет особые привилегии или статус
    CLOSED(4);//Клиент закрыл свой счет

    private final int value;
    ClientStatus(int value) {
        this.value = value;
    }
}
