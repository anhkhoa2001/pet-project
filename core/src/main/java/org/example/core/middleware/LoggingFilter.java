package org.example.core.middleware;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Wrap request and response to read their contents
        CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(request);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);

        long start = System.currentTimeMillis();
        String method = request.getMethod();
        String uri = request.getRequestURI();

        try {
            filterChain.doFilter(wrappedRequest, wrappedResponse);
        } finally {
            afterResponse(wrappedRequest, wrappedResponse, start, method, uri);
        }
    }

    private void afterResponse(CachedBodyHttpServletRequest wrappedRequest, ContentCachingResponseWrapper wrappedResponse,
                               long start, String method, String uri) throws IOException {
        long duration = System.currentTimeMillis() - start;

        // Read request body (if needed)
        String requestBody = new String(wrappedRequest.getCachedBody(), StandardCharsets.UTF_8);

        // Read response body
        String responseBody = new String(wrappedResponse.getContentAsByteArray(), StandardCharsets.UTF_8);

        // Log details
        System.out.printf("""
                📥 REQUEST: %s %s
                🧾 Request Body: %s
                📤 RESPONSE: %d
                📃 Response Body: %s
                ⏱ Execution Time: %d ms
                ---------------------------------------
                """,
                method,
                uri,
                requestBody,
                wrappedResponse.getStatus(),
                responseBody,
                duration
        );

        // Copy response body back to actual output
        wrappedResponse.copyBodyToResponse();
    }


    public class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {

        private final byte[] cachedBody;

        public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
            super(request);
            InputStream requestInputStream = request.getInputStream();
            this.cachedBody = requestInputStream.readAllBytes(); // Java 9+
        }

        @Override
        public ServletInputStream getInputStream() {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cachedBody);

            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return byteArrayInputStream.available() == 0;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener listener) {
                }

                @Override
                public int read() {
                    return byteArrayInputStream.read();
                }
            };
        }

        public byte[] getCachedBody() {
            return this.cachedBody;
        }
    }

}

