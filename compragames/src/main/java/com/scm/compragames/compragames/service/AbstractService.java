package com.scm.compragames.compragames.service;

import javassist.NotFoundException;

import java.util.Collection;

public interface AbstractService <T, Y> {
    T findById(Y id) throws NotFoundException;

    T save(T obj) throws Exception;

    T disable(Y id) throws NotFoundException;

    Collection<T> findAll() throws Exception;

    Collection<T> findAllByActiveTrue() throws Exception;
}
