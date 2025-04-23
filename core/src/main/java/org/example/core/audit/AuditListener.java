package org.example.core.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.example.core.model.ABaseModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuditListener {

    @PrePersist
    public void prePersist(ABaseModel entity) {
        RequestContext context = RequestContext.get();
        if (context != null) {
            entity.setCreateBy(context.getUsername());
            entity.setCreateAt(context.getTimestamp());
        }
    }

    @PreUpdate
    public void preUpdate(ABaseModel entity) {
        log.info("Is entity managed? {}", "checking if entity is managed");
        RequestContext context = RequestContext.get();
        if (context != null) {
            entity.setUpdateBy(context.getUsername());
            entity.setUpdateAt(context.getTimestamp());
        }
    }

}
