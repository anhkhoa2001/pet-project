package org.example.core.converter.model2dto;

import org.example.core.dto.ABaseDto;
import org.example.core.exception.LayerConverterException;
import org.example.core.model.ABaseModel;
import org.example.core.util.Constant;
import org.example.core.util.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class AModel2DTO<MODEL extends ABaseModel, DTO extends ABaseDto> implements IModel2DTO<MODEL, DTO> {
    private final Class<DTO> dtoClass;

    protected AModel2DTO(Class<DTO> dtoClass) {
        this.dtoClass = dtoClass;
    }

    @Override
    public void copyDTO(MODEL source, DTO target) {

    }

    @Override
    public List<DTO> toListDTO(List<MODEL> models) {
        if(ValidateUtils.isNull(models)) {
            return List.of();
        }

        return models.stream().map(this::toDTO).toList();
    }

    @Override
    public DTO toDTO(MODEL source) {
        try {
            DTO dto = dtoClass.getDeclaredConstructor().newInstance();

            BeanUtils.copyProperties(source, dto);
            return dto;
        } catch (Exception e) {
            throw new LayerConverterException(Constant.ERROR_CODE.ERROR_CODE_CONVERTER, "loi o day");
        }
    }

}
