package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.dto.ABaseDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO extends ABaseDto {

    private String id;
    private String request;
    private String response;

}
