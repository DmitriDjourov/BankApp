package com.djourov.bankapp.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String url;
}
