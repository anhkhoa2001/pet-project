package com.example.auth.filter.auth;

import com.example.auth.config.GWhiteListContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.function.Supplier;

@Component
public class AuthorizationMangerCustom implements AuthorizationManager<HttpServletRequest> {

    @Autowired
    private AuthorizationResultCustom authorizationResultCustom;

    @Override
    public void verify(Supplier<Authentication> authentication, HttpServletRequest object) {

    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, HttpServletRequest object) {
        return null;
    }

    @Override
    public AuthorizationResult authorize(Supplier<Authentication> authentication, HttpServletRequest request) {
        String url = request.getRequestURI();

        //check in white list
        for(String pattern : GWhiteListContext.GW.keySet()) {
            if (matches(pattern, url)) {
                return authorizationResultCustom;
            }
        }

        return null;
    }

    public static boolean matches(String pattern, String path) {
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(pattern, path);
    }
}
