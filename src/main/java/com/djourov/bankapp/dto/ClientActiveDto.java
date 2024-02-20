package com.djourov.bankapp.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClientActiveDto {
    String lastName;
    String firstName;
    String phone;
    String status;
    }
