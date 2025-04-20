package com.example.test.converter.dto2model;

import com.example.test.dto.LogDTO;
import com.example.test.model.LogModel;
import org.example.core.converter.dto2model.ADTO2Model;
import org.example.core.util.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogDTO2Model extends ADTO2Model<LogDTO, LogModel> {

    protected LogDTO2Model() {
        super(LogModel.class);
    }

    @Override
    public void copyModel(LogDTO source, LogModel target) {

    }

    @Override
    public List<LogModel> toListModel(List<LogDTO> dtos) {
        if(ValidateUtils.isNull(dtos)) {
            return List.of();
        }

        return dtos.stream().map(this::toModel).toList();
    }

    @Override
    public LogModel toModel(LogDTO source) {
        LogModel logModel = super.toModel(source);
        BeanUtils.copyProperties(source, logModel);
        return logModel;
    }
}
