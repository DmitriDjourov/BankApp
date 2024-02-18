package com.djourov.bankapp.dto;

import com.djourov.bankapp.entity.enums.ManagerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
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
