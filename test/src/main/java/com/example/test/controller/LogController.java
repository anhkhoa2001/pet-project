package com.example.test.controller;

import com.example.test.dto.LogDTO;
import com.example.test.request.LogRequest;
import com.example.test.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.example.core.controller.ABaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Slf4j
public class LogController extends ABaseController<LogRequest, LogDTO, String> {

    public LogController(LogService logService) {
        super(logService);
    }
}
