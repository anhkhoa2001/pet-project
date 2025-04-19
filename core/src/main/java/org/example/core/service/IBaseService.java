package org.example.core.service;

import org.example.core.model.ABaseModel;

import java.util.List;

public interface IBaseService<MODEL extends ABaseModel, ID> {

    MODEL getById(ID id);
    List<MODEL> getAll();
    void delete(ID id);

}
