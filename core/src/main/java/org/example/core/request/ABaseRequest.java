package org.example.core.request;

import lombok.Data;

@Data
public abstract class ABaseRequest<T> {
    private T id;
}
