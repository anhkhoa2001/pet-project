package com.example.auth.config;

import com.example.auth.filter.AuthorizationFilterCustom;
import com.example.auth.filter.auth.AuthorizationMangerCustom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(AbstractHttpConfigurer::disable);
        http.addFilterAfter(
                new AuthorizationFilterCustom(new AuthorizationMangerCustom()),
                ExceptionTranslationFilter.class
        );
        return http.build();
    }

}
