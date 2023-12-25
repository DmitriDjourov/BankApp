package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementInterestRateStatus {
    FIXED,       // Фиксированная процентная ставка
    VARIABLE,    // Плавающая процентная ставка
    PROMOTIONAL; // Промо-процентная ставка (акционная)

    public static AgreementInterestRateStatus agreementInterestRateStatus(int code) {
        return switch (code) {
            case 1 -> FIXED;
            case 2 -> VARIABLE;
            case 3 -> PROMOTIONAL;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}

