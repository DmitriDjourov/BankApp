package com.djourov.bankapp.security;

import java.security.SecureRandom;
import java.util.Base64;

public class JwtKeyGenerator {

    public static void main(String[] args) {
        byte[] keyBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);

        System.out.println("Generated JWT Signing Key: " + base64Key);
    }
}
