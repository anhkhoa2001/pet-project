package com.example.test.request;

import lombok.Data;
import org.example.core.request.ABaseRequest;

@Data
public class LogRequest extends ABaseRequest {

    private String request;
    private String response;
}
