package com.example.test.service.impl;

import com.example.test.dto.LogDTO;
import com.example.test.model.LogModel;
import com.example.test.repository.LogRepository;
import com.example.test.request.LogRequest;
import com.example.test.service.LogService;
import org.example.core.converter.model2dto.IModel2DTO;
import org.example.core.service.impl.ABaseService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ABaseService<LogRequest, LogDTO, String, LogModel> implements LogService {

    public LogServiceImpl(LogRepository logRepository, IModel2DTO<LogModel, LogDTO> model2DTO) {
        super(logRepository, model2DTO);
    }
}
