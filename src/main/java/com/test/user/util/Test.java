package com.test.user.util;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

public class Test {
    public static void main(String[] args) {
        // Tạo secret key 64 byte (512 bit) phù hợp với HS512
        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS512);
        String encodedKey = Encoders.BASE64.encode(key.getEncoded());

        System.out.println("Generated Secret Key: " + encodedKey);
    }
}
