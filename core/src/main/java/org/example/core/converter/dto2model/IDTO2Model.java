package org.example.core.converter.dto2model;

import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;

import java.util.List;

public interface IDTO2Model<MODEL extends ABaseModel, DTO extends ABaseDto> {

    void copyModel(DTO source, MODEL target);

    MODEL toModel(DTO model);

    List<MODEL> toListModel(List<DTO> dtos);

}
