package org.example.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.converter.dto2model.ADTO2Model;
import org.example.core.converter.model2dto.AModel2DTO;
import org.example.core.converter.model2dto.IModel2DTO;
import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;
import org.example.core.repository.IBaseRepository;
import org.example.core.request.ABaseRequest;
import org.example.core.service.IBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ABaseService<REQUEST extends ABaseRequest, DTO extends ABaseDto, ID, MODEL extends ABaseModel>
                    implements IBaseService<REQUEST, DTO, ID> {

    private final IBaseRepository<MODEL, ID> repository;
    private final IModel2DTO<MODEL, DTO> model2DTO;

    @Override
    @Transactional(readOnly = true)
    public DTO getById(ID id) {
        MODEL model = repository.findById(id).orElseThrow();
        return model2DTO.toDTO(model);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getAll() {
        List<MODEL> models = repository.findAll();
        return model2DTO.toListDTO(models);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public DTO update(REQUEST request) {
        return null;
    }

    @Override
    @Transactional
    public DTO create(REQUEST request) {
        return null;
    }
}
