package com.example.university.service.security_service;

import com.example.university.entity.auth_entities.Token;
import com.example.university.enums.TokenType;
import com.example.university.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        final String token = authHeader.substring(7);

        Token logoutToken = Token
                .builder()
                .token(token)
                .tokenType(TokenType.BEARER)
                .expired(true)
                .revoked(true)
                .build();
        tokenRepository.save(logoutToken);
    }
}
