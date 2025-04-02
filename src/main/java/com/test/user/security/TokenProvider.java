package com.test.user.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenProvider {

    @Value("${user-service.security.jwt.secret-key}")
    private String secretKey;

    @Value("${user-service.security.jwt.expire-in}")
    private int expireIn;

    public String createToken(final String userName) {
        return generateToken(userName, secretKey, expireIn);
    }

    private String generateToken(final String subject, final String secretKey, final int expiration) {
        byte [] keyBytes = Base64.getDecoder().decode(secretKey);
        Assert.isTrue(keyBytes.length >= 64, "SecretKey need longer");
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Date expirationDate = Date.from(Instant.now().plus(expiration, ChronoUnit.SECONDS));

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
