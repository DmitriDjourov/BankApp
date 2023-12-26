package com.djourov.bankapp.entity.enums;

import lombok.Getter;

@Getter
public enum AgreementStatus {
    ACTIVE,// Соглашение в настоящее время действующее и действительное
    COMPLETED,// Соглашение успешно завершено, все его условия выполнены
    CANCELLED,// Соглашение было отменено до его завершения.
    EXPIRED,// Соглашение было активным, но срок его действия истек.
    DEFERRED;// Действие соглашения было отложено на будущее.
}
