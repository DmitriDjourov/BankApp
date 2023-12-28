package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementStatus {
    ACTIVE(0),// Соглашение в настоящее время действующее и действительное
    COMPLETED(1),// Соглашение успешно завершено, все его условия выполнены
    CANCELLED(2),// Соглашение было отменено до его завершения.
    EXPIRED(3),// Соглашение было активным, но срок его действия истек.
    DEFERRED(4);// Действие соглашения было отложено на будущее.

    private final int value;
    AgreementStatus(int value) {
        this.value = value;
    }
}
