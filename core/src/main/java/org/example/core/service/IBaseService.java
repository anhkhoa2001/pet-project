package org.example.core.service;

import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;
import org.example.core.request.ABaseRequest;

import java.util.List;

public interface IBaseService<REQUEST extends ABaseRequest, DTO extends ABaseDto, ID> {

    DTO getById(ID id);
    List<DTO> getAll();
    void delete(ID id);
    DTO update(REQUEST request) throws InterruptedException;
    DTO create(REQUEST request);
}
