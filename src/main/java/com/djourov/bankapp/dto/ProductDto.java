package com.djourov.bankapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    String name;
    String managerId;
    String limit;
    String interestRate;
    String currencyCode;
    String status;
}
