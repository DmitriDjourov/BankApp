package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ClientStatus {
    ACTIVE,// Клиент активно использует банковские услуги
    FROZEN,//Действие счета или услуги клиента временно приостановлено
    OVERDUE,//Клиент имеет просроченные платежи или задолженность перед банком.
    PRIVILEGED,//Клиент имеет особые привилегии или статус
    CLOSED;//Клиент закрыл свой счет
}
