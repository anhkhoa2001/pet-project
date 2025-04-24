package com.example.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthorizationFilterCustom extends AuthorizationFilter {
    public AuthorizationFilterCustom(AuthorizationManager<HttpServletRequest> authorizationManager) {
        super(authorizationManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Custom logic before the filter chain
        System.out.println("Custom Authorization Filter: Request URI - " + httpRequest.getRequestURI());

        // Call the parent class's doFilter to continue the filter chain
        super.doFilter(request, response, chain);

        // Custom logic after the filter chain
        System.out.println("Custom Authorization Filter: Response Status - " + httpResponse.getStatus());
    }
}
