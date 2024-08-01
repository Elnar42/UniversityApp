package com.example.university.controller.app_controller;

import com.example.university.entity.main_entities.MainEntity;
import com.example.university.service.app_service.MainService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Transactional
@RequiredArgsConstructor
public abstract class MainController<D, ID extends Serializable, E extends MainEntity> {

    private final MainService<D, ID, E> service;

    @Cacheable(cacheNames = "all")
    @GetMapping
    public Page<D> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @Cacheable(cacheNames = "byId", key = "#id", unless = "#result == null")
    @GetMapping("/{id}")
    public D getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @CacheEvict(cacheNames = "create", allEntries = true)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public D create(@RequestBody @Valid D element) {
        return service.create(element);
    }


    @CacheEvict(cacheNames = "byId", key = "#id")
    @PutMapping("/{id}")
    public D updateById(@PathVariable ID id, @RequestBody @Valid D element) {
        return service.updateById(id, element);
    }

    @CacheEvict(cacheNames = "byId", key = "#id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

}
