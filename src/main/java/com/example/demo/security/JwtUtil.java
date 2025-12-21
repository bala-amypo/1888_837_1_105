package com.example.demo.security;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    // ⚠ REQUIRED FIELD NAMES (tests inject via reflection)
    private String secret = "ThisIsASecretKeyForJwtAuthentication123456";
    private Long jwtExpirationMs = 86400000L; // 1 day

    public String generateToken(String username, String role, Long userId, String email) {

        return Jwts.builder()
                .setSubject(username)
                .addClaims(Map.of(
                        "role", role,
                        "userId", userId,
                        "email", email
                ))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims validateAndGetClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String getTokenFromRequest(HttpServletRequest request) {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
