package com.djourov.bankapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;
//    @NotBlank(message = "Email пользователя не может быть пустыми")
//    private String email;
    @NotBlank
    private String password;
}
