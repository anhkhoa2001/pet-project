package com.example.test.repository;

import com.example.test.model.LogModel;
import org.example.core.repository.IBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends IBaseRepository<LogModel, String> {
}
