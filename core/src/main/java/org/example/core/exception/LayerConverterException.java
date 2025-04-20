package org.example.core.exception;

import lombok.Getter;

public class LayerConverterException extends RuntimeException {
    @Getter
    private int code;
    @Getter
    private String message;

    public LayerConverterException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
