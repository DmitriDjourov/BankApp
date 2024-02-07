package com.djourov.bankapp.dto;

import lombok.Data;

@Data
public class ProductDto {
    String name;
    String managerId;
    String limit;
    String interestRate;
    String currencyCode;
    String status;
}
