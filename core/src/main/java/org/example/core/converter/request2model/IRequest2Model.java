package org.example.core.converter.request2model;

import org.example.core.model.ABaseModel;
import org.example.core.request.ABaseRequest;

import java.util.List;

public interface IRequest2Model<REQUEST extends ABaseRequest, MODEL extends ABaseModel> {

    MODEL toModel(REQUEST request);

    List<MODEL> toListModel(List<REQUEST> sources);

    MODEL toModelWithIgnoreFields(REQUEST request, String... ignoreFields);

    void copyModel(REQUEST source, MODEL target);
}
