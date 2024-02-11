package com.djourov.bankapp.dto;

import com.djourov.bankapp.entity.enums.ManagerStatus;

import lombok.Value;

@Value
public class ClientDto {
    String firstName;
    String lastName;
    /**
     * Manager
     */
    String firstNameManager;
    String lastNameManager;
    ManagerStatus status;
}
