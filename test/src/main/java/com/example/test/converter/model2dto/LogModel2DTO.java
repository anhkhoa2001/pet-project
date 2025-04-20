package com.example.test.converter.model2dto;

import com.example.test.dto.LogDTO;
import com.example.test.model.LogModel;
import org.example.core.converter.model2dto.AModel2DTO;
import org.springframework.stereotype.Component;

@Component
public class LogModel2DTO extends AModel2DTO<LogModel, LogDTO> {

    protected LogModel2DTO() {
        super(LogDTO.class);
    }
}
