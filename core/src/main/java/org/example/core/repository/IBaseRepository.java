package org.example.core.repository;

import org.example.core.model.ABaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository<MODEL extends ABaseModel, ID> extends JpaRepository<MODEL, ID> {
}
