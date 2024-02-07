package com.djourov.bankapp.dto;

import com.djourov.bankapp.entity.enums.ManagerStatus;
import lombok.Data;

@Data
public class AccountDto {
    /**
     * Account
     */

    private String id;
    private String accountNumber;

    /**
     * Client
     */
    private String firstName;
    private String lastName;

    /**
     * Manager
     */
    private ManagerStatus status;
}
