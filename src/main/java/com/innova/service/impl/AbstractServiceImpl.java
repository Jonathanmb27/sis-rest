package com.innova.service.impl;

import com.innova.domain.AbstractEntity;
import com.innova.domain.Cancelado;
import com.innova.service.AbstractService;

import java.util.Optional;

public  abstract class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {


    @Override
    public void save(T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public int deleteById(Long entityId) {
        return 0;
    }

    @Override
    public Optional<T> findById(Long entityId) {
        return Optional.empty();
    }
}
