package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ManagerStatus {
    SENIOR_MANAGER(0),// Менеджер верхнего уровня
    CREDIT_MANAGER(1),//Специалист по управлению кредитными продуктами
    CUSTOMER_SERVICE_MANAGER(2),//Ответственный за качество обслуживания клиентов
    SALES_MANAGER(3);//Ответственный за управление и развитие отдела по продажам банковских продуктов

    private final int value;

    ManagerStatus(int value) {
        this.value = value;
    }
}
