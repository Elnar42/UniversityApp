package com.example.university.config;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.entity.auth_entities.User;
import com.example.university.service.security_service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class  CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final JwtService jwtService;

    public CustomAuthenticationFilter(ObjectMapper objectMapper,
                                      AuthenticationManager authenticationManager,
                                      JwtService jwtService) {
        this.objectMapper = objectMapper;
        setAuthenticationManager(authenticationManager);
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthenticationRequest authRequest = objectMapper.readValue(request.getReader(), AuthenticationRequest.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
            return getAuthenticationManager().authenticate(authToken);
        } catch (IOException | AuthenticationException ef) {
            throw new RuntimeException("Unable to authenticate user");
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        String accessToken = jwtService.generateToken(user);
        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .token(accessToken)
                .build();
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(authResponse);
        response.getWriter().write(jsonResponse);
    }

}
