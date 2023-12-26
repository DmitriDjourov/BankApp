package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementInterestRateStatus {
    FIXED,       // Фиксированная процентная ставка
    VARIABLE,    // Плавающая процентная ставка
    PROMOTIONAL; // Промо-процентная ставка (акционная)
}

