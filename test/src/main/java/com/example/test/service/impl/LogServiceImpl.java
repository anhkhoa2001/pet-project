package com.example.test.service.impl;

import com.example.test.converter.model2dto.ILogModel2DTO;
import com.example.test.converter.request2model.ILogRequest2LogModel;
import com.example.test.dto.LogDTO;
import com.example.test.model.LogModel;
import com.example.test.repository.LogRepository;
import com.example.test.request.LogRequest;
import com.example.test.service.LogService;
import org.example.core.service.impl.ABaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LogServiceImpl extends ABaseService<LogRequest, LogDTO, String, LogModel> implements LogService {

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ILogRequest2LogModel request2Model;
    @Autowired
    private ILogModel2DTO logModel2DTO;


    @Override
    @Transactional
    public LogDTO update(LogRequest request) throws InterruptedException {
        String id = request.getId();
        Optional<LogModel> optionalModel = this.logRepository.findById(id);

        if(optionalModel.isEmpty()) {
            throw new IllegalArgumentException("Model not found with id: " + id);
        }
        LogModel model = optionalModel.get();
        request2Model.copyModel(request, model);
        LogModel updatedModel = logRepository.save(model);
        return logModel2DTO.toDTO(updatedModel);
    }

}
