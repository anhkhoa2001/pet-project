package org.example.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.util.ValidateUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBase<T> {

    private Long timestamp;
    private T data;
    private int statusCode;
    private String message;
    private String path;

    public Long getTimestamp() {
        return ValidateUtils.isNull(timestamp) ? System.currentTimeMillis() : timestamp;
    }

    public ResponseBase(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseBase<T> build(T data) {
        ResponseBase<T> response = new ResponseBase<>();
        response.setData(data);
        response.setStatusCode(200);
        response.setMessage("Success");
        return response;
    }
}
