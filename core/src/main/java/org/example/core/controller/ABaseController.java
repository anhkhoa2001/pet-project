package org.example.core.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.dto.ABaseDto;
import org.example.core.request.ABaseRequest;
import org.example.core.service.IBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public abstract class ABaseController<REQUEST extends ABaseRequest, DTO extends ABaseDto, ID> {

    private final IBaseService<REQUEST, DTO, ID> service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable ID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/create")
    public ResponseEntity<DTO> create(@RequestBody REQUEST request) {
        return ResponseEntity.ok(service.create(request));
    }

    @PostMapping("/update")
    public ResponseEntity<DTO> update(@RequestBody REQUEST request) throws InterruptedException {
        return ResponseEntity.ok(service.update(request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
