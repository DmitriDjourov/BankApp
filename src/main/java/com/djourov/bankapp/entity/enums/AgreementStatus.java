package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementStatus {
    ACTIVE,// Соглашение в настоящее время действующее и действительное
    COMPLETED,// Соглашение успешно завершено, все его условия выполнены
    CANCELLED,// Соглашение было отменено до его завершения.
    EXPIRED,// Соглашение было активным, но срок его действия истек.
    DEFERRED;// Действие соглашения было отложено на будущее.
    public static AgreementStatus agreementStatus(int code) {
        return switch (code) {
            case 1 -> ACTIVE;
            case 2 -> COMPLETED;
            case 3 -> CANCELLED;
            case 4 -> EXPIRED;
            case 5 -> DEFERRED;
            default -> throw new IllegalArgumentException("Unexpected value: " + code);
        };
    }
}
