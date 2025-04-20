package com.example.test.service;

import com.example.test.dto.LogDTO;
import com.example.test.request.LogRequest;
import org.example.core.service.IBaseService;
import org.springframework.stereotype.Service;

@Service
public interface LogService extends IBaseService<LogRequest, LogDTO, String> {
}
