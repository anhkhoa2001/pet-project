package org.example.core.middleware;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.core.dto.ResponseBase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class WrapperFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(request, wrappedResponse); // run controller logic

        byte[] content = wrappedResponse.getContentAsByteArray();
        String originalBody = new String(content, StandardCharsets.UTF_8);


        // Try to parse original JSON or return as string
        Object data;
        try {
            data = new ObjectMapper().readValue(originalBody, Object.class); // JSON -> Object
        } catch (Exception e) {
            data = originalBody; // Fallback to raw string
        }

        ResponseBase responseBase = new ResponseBase().build(data);
        responseBase.setPath(request.getRequestURI());
        // Write the new wrapped body
        byte[] newBody = new ObjectMapper().writeValueAsBytes(responseBase);
        response.setContentLength(newBody.length);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().write(newBody);
    }
}

