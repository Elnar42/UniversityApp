package com.example.university.service.app_service;

import com.example.university.entity.main_entities.MainEntity;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.MainMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.time.LocalDateTime;

//key, value id
@RequiredArgsConstructor
public abstract class MainService<D, ID extends Serializable, O extends MainEntity> {

    private static final Logger log = LoggerFactory.getLogger(MainService.class);
    private final JpaRepositoryImplementation<O, ID> repository;
    private final MainMapper<D, O> mapper;

    /*
    MANUAL CACHING BELOW
    private LoadingCache<Object,Object> cache -> synchronous caching
    private AsyncLoadingCache<Object, Object> cache; -> asynchronous caching
    get method on cache is more preferable than getIfPresent since it supports atomicity!
    */

    @Cacheable(value = "cacheOne", condition = "#pageable != null")
    public Page<D> getAll(Pageable pageable) {
        log.info("Reading from DB for All");
        Page<O> all = repository.findAll(pageable);
        return all.map(mapper::toDto);
    }

    // Json format deyismek, baxmag lazimdi7
    @Cacheable(value = "cacheOne", key = "#id", unless = "#result == null")
    public D getById(ID id) {
        log.info("Reading from DB for ID");
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now()));
    }

    @CacheEvict(value = "cacheOne", allEntries = true)
    public D create(D element) {
        log.info("Creating new element, clearing cache");
        return mapper.toDto(repository.save(mapper.toEntity(element)));
    }

    @CacheEvict(value = "cacheOne", key = "#id")  // cache -> overrides existing one
    public D updateById(ID id, D element) {
        return repository
                .findById(id)
                .map(object -> repository.save(mapper.toEntity(object, element)))
                .map(mapper::toDto)
                .orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now()));
    }

    @CacheEvict(value = "cacheOne", key = "#id")
    public void deleteById(ID id) {
        log.info("Deleting element from cache for consistency");
        repository.delete(repository.findById(id).orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now())));
    }
}
