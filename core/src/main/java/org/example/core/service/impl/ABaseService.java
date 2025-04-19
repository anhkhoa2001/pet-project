package org.example.core.service.impl;

import org.example.core.model.ABaseModel;
import org.example.core.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ABaseService<MODEL extends ABaseModel, ID> implements IBaseService<MODEL, ID> {
    @Override
    public MODEL getById(ID id) {
        return null;
    }

    @Override
    public List<MODEL> getAll() {
        return null;
    }

    @Override
    public void delete(ID id) {

    }
}
