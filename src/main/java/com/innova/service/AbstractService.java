package com.innova.service;



import java.util.Optional;

public interface AbstractService<T> {

    void save(T entity);

    void delete(T entity);

    int deleteById(Long entityId);

    Optional<T> findById(Long entityId);
}
