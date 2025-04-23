package org.example.core.converter.request2model;

import org.example.core.exception.LayerConverterException;
import org.example.core.model.ABaseModel;
import org.example.core.request.ABaseRequest;
import org.example.core.util.Constant;
import org.example.core.util.ValidateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class ARequest2Model <REQUEST extends ABaseRequest, MODEL extends ABaseModel> implements IRequest2Model<REQUEST, MODEL> {

    private final Class<MODEL> modelClass;
    private final String[] ignoreFields = new String[] { "id", "createdAt", "createBy", "updatedAt", "updateBy" };

    protected ARequest2Model(Class<MODEL> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public MODEL toModel(REQUEST source) {
        try {
            MODEL model = modelClass.getDeclaredConstructor().newInstance();

            BeanUtils.copyProperties(source, model);
            return model;
        } catch (Exception e) {
            throw new LayerConverterException(Constant.ERROR_CODE.ERROR_CODE_CONVERTER, e.getMessage());
        }
    }

    @Override
    public List<MODEL> toListModel(List<REQUEST> sources) {
        if(ValidateUtils.isNull(sources)) {
            return List.of();
        }

        return sources.stream().map(this::toModel).toList();
    }

    @Override
    public MODEL toModelWithIgnoreFields(REQUEST request, String... ignoreFields) {
        try {
            MODEL model = modelClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(request, model, ignoreFields);
            return model;
        } catch (Exception e) {
            throw new LayerConverterException(Constant.ERROR_CODE.ERROR_CODE_CONVERTER, e.getMessage());
        }
    }

    @Override
    public void copyModel(REQUEST source, MODEL target) {
        try {
            BeanUtils.copyProperties(source, target, ignoreFields);
        } catch (Exception e) {
            throw new LayerConverterException(Constant.ERROR_CODE.ERROR_CODE_CONVERTER, e.getMessage());
        }
    }
}
