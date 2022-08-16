package com.grego.mscourseservice.service;

public interface CrudService <T> {

    T save(T t);
    T findById(Long id);
    Iterable<T> findAll();
    void delete(T t);





}
