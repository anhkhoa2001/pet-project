package com.example.test.converter.model2dto;

import com.example.test.dto.LogDTO;
import com.example.test.model.LogModel;
import org.example.core.converter.model2dto.AModel2DTO;
import org.springframework.stereotype.Component;

@Component
public class LogModel2DTO extends AModel2DTO<LogModel, LogDTO> implements ILogModel2DTO {

    protected LogModel2DTO() {
        super(LogDTO.class);
    }

   /* @Override
    public LogModel toModel(LogRequest request) {
        LogModel logModel = new LogModel();
        BeanUtils.copyProperties(request, logModel);
        return logModel;
    }

    @Override
    public List<LogModel> toListModel(List<LogRequest> sources) {
        if(ValidateUtils.isNull(sources)) {
            return List.of();
        }
        return sources.stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public LogModel toModelWithIgnoreFields(LogRequest request, String... ignoreFields) {
        LogModel logModel = new LogModel();
        BeanUtils.copyProperties(request, logModel, ignoreFields);
        return logModel;
    }

    @Override
    public void copyModel(LogRequest source, LogModel target) {
        BeanUtils.copyProperties(source, target);
    }*/
}
