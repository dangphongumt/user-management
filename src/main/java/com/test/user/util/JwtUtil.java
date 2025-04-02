package com.test.user.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.util.Assert;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

public class JwtUtil {

    private static String generateToken(final String subject, final String secretKey, final int expiration) {
        byte [] keyBytes = Base64.getDecoder().decode(secretKey);
        Assert.isTrue(keyBytes.length >= 64, "SecretKey need longer");
        Key key = Keys.hmacShaKeyFor(keyBytes);

        Date expirationDate = Date.from(Instant.now().plus(expiration, ChronoUnit.MINUTES));

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
