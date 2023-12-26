package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum ManagerStatus {
    SENIOR_MANAGER,// Менеджер верхнего уровня
    CREDIT_MANAGER,//Специалист по управлению кредитными продуктами
    CUSTOMER_SERVICE_MANAGER,//Ответственный за качество обслуживания клиентов
    SALES_MANAGER;//Ответственный за управление и развитие отдела по продажам банковских продуктов
}
