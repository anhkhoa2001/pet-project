package com.example.auth.filter.auth;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.time-expired}")
    private long timeExpired;

    @Value("${jwt.private-key}")
    private String privateKey;

    private SecretKey key;

    /*@PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(privateKey.getBytes());
    }

    // Tạo JWT
    public String generateToken(String username) {
        JwtBuilder builder = Jwts.builder();

        return builder
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + timeExpired))
                .signWith(key)
                .compact();
    }

    // Validate JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith((SecretKey) key).build().parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            System.out.println("❌ Invalid JWT: " + e.getMessage());
            return false;
        }
    }

    // Lấy username từ token
    public String getUsernameFromToken(String token) {
        JwtParser parser = Jwts.parser().verifyWith((SecretKey) key).build();
        return parser.parseSignedClaims(token).getPayload().getSubject();
    }*/
}
