package com.djourov.bankapp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
    @Value("${variables.jwtSecret}")
    private String jwtSecret;

    @Value("${variables.jwtExpirationMS}")
    private int jwtExpirationMS;


}
