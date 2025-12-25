package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String username) {
        return "dummy-jwt-token";
    }

    public boolean validateToken(String token) {
        return token != null;
    }
}
