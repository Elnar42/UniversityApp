package com.example.university.config;

import com.example.university.enums.Role;
import com.example.university.service.security_service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] WHITE_LIST_URL = {
            "swagger-ui.html",
            "swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/webjars/**",
            "/api/v1/auth/sign-up",
            "/login"
    };

    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final ObjectMapper objectMapper;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtService jwtService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        return new CustomAuthenticationFilter(objectMapper, authenticationManager(), jwtService);
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/universities/**").hasAuthority(Role.ADMIN.name())
                                .requestMatchers("/students/**", "/programs/**", "/courses/**", "/enrollments/**", "/faculties/**").hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name())
                                .requestMatchers("/coursesSections/**").hasAnyAuthority(Role.MANAGER.name(), Role.ADMIN.name())
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilter(customAuthenticationFilter())
                .addFilterBefore(jwtAuthenticationFilter, CustomAuthenticationFilter.class)
                .logout(logout -> {
                    logout.logoutUrl("/api/v1/auth/logout");
                    logout.addLogoutHandler(logoutHandler);
                    logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
                });

        return http.build();
    }

}
