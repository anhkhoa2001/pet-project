package org.example.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.model.ABaseModel;
import org.example.core.service.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public abstract class ABaseController<MODEL extends ABaseModel, ID> {

    private final IBaseService<MODEL, ID> service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable ID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
