package org.example.core.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.core.converter.model2dto.IModel2DTO;
import org.example.core.converter.request2model.IRequest2Model;
import org.example.core.dto.ABaseDto;
import org.example.core.model.ABaseModel;
import org.example.core.repository.IBaseRepository;
import org.example.core.request.ABaseRequest;
import org.example.core.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ABaseService<REQUEST extends ABaseRequest<ID>, DTO extends ABaseDto, ID, MODEL extends ABaseModel>
                    implements IBaseService<REQUEST, DTO, ID> {

    @Autowired
    private IBaseRepository<MODEL, ID> repository;

    @Autowired
    private IModel2DTO<MODEL, DTO> model2DTO;

    @Autowired
    private IRequest2Model<REQUEST, MODEL> request2Model;

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
    public DTO update(REQUEST request) throws InterruptedException {
        ID id = request.getId();
        Optional<MODEL> optionalModel = repository.findById(id);

        if(optionalModel.isEmpty()) {
            throw new IllegalArgumentException("Model not found with id: " + id);
        }
        MODEL model = optionalModel.get();
        request2Model.copyModel(request, model);
        MODEL updatedModel = repository.save(model);
        return model2DTO.toDTO(updatedModel);
    }

    @Override
    @Transactional
    public DTO create(REQUEST request) {
        MODEL model = request2Model.toModel(request);
        MODEL savedModel = repository.save(model);
        return model2DTO.toDTO(savedModel);
    }
}
