package org.example.core.converter.dto2model;

import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;
import org.example.core.util.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class ADTO2Model<DTO extends ABaseDto, MODEL extends ABaseModel> implements IDTO2Model<MODEL, DTO> {
    private final Class<MODEL> modelClass;

    protected ADTO2Model(Class<MODEL> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public void copyModel(DTO source, MODEL target) {

    }

    @Override
    public List<MODEL> toListModel(List<DTO> dtos) {
        if(ValidateUtils.isNull(dtos)) {
            return List.of();
        }

        return dtos.stream().map(this::toModel).toList();
    }

    @Override
    public MODEL toModel(DTO source) {
        try {
            MODEL model = modelClass.getDeclaredConstructor().newInstance();

            BeanUtils.copyProperties(source, model);
            return model;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
