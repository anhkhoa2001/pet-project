package org.example.core.converter.model2dto;

import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;

import java.util.List;

public interface IModel2DTO<MODEL extends ABaseModel, DTO extends ABaseDto> {

    void copyDTO(MODEL source, DTO target);

    List<DTO> toListDTO(List<MODEL> models);

    DTO toDTO(MODEL source);
}
