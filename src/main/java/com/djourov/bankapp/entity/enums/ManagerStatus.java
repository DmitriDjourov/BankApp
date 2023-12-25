package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ManagerStatus {
    SENIOR_MANAGER,// Менеджер верхнего уровня
    CREDIT_MANAGER,//Специалист по управлению кредитными продуктами
    CUSTOMER_SERVICE_MANAGER,//Ответственный за качество обслуживания клиентов
    SALES_MANAGER;//Ответственный за управление и развитие отдела по продажам банковских продуктов
    public static ManagerStatus managerStatus(int code) {
        return switch (code) {
            case 1 -> SENIOR_MANAGER;
            case 2 -> CREDIT_MANAGER;
            case 3 -> CUSTOMER_SERVICE_MANAGER;
            case 4 -> SALES_MANAGER;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
