package com.example.test.converter.request2model;

import com.example.test.model.LogModel;
import com.example.test.request.LogRequest;
import org.example.core.converter.request2model.ARequest2Model;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogRequest2LogModelImpl extends ARequest2Model<LogRequest, LogModel> implements ILogRequest2LogModel {

    public LogRequest2LogModelImpl() {
        super(LogModel.class);
    }

    @Override
    public LogModel toModel(LogRequest request) {
        LogModel logModel = new LogModel();
        BeanUtils.copyProperties(request, logModel);
        return logModel;
    }

    @Override
    public List<LogModel> toListModel(List<LogRequest> sources) {
        return sources.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public LogModel toModelWithIgnoreFields(LogRequest request, String... ignoreFields) {
        return null;
    }
}
