package com.example.auth.filter.auth;

import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationResultCustom implements AuthorizationResult {
    @Override
    public boolean isGranted() {
        return true;
    }
}
