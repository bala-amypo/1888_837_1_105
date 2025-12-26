package com.example.demo.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Dummy token generator
    public String generateToken(String username, String role, Long userId, String email) {
        return "dummy-token-" + username;
    }

    // Dummy extractor
    public String extractUsername(String token) {
        if (token == null) return null;
        return token.replace("dummy-token-", "");
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
