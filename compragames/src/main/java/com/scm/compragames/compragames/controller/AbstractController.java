package com.scm.compragames.compragames.controller;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.scm.compragames.compragames.data.model.BaseModel;
import com.scm.compragames.compragames.service.AbstractService;
import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController<S extends AbstractService<T, Y>, T extends BaseModel, Y extends Long> {
    protected S service;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public AbstractController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Object> findAll() throws Exception {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Y id) throws Exception {
        return retrieve(CrudType.GET_ID, id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> disable(@PathVariable(value = "id") Y id) throws Exception {
        return retrieve(CrudType.DELETE, id);
    }

    @SuppressWarnings("rawtypes")
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Y id, @RequestBody T entity) throws Exception {
        entity.setId(id);
        return ResponseEntity.ok(service.save(entity));
    }

    @SuppressWarnings("rawtypes")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody T entity) throws Exception {
        return ResponseEntity.ok(service.save(entity));
    }

    private ResponseEntity<Object> retrieve(CrudType type, Y id) throws Exception {
        switch (type) {
            case GET_ID:
                return ResponseEntity.ok(service.findById(id));
            case GET_ALL:
                return ResponseEntity.ok(service.findAllByActiveTrue());
            case DELETE:
                return ResponseEntity.ok(service.disable(id));
            default:
                break;
        }

        return ResponseEntity.ok(service.findById(id));
    }

    private enum CrudType {
        GET_ID, GET_ALL, DELETE
    }

    @ExceptionHandler
    public ResponseEntity<Object> handler(Exception e) {
        log.error("AbstractController.handler: " + e.getMessage(), e);

        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
