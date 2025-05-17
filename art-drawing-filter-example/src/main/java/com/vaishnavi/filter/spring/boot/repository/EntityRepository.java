package com.vaishnavi.filter.spring.boot.repository;

import java.util.List;

public interface EntityRepository<T> {
    boolean store(T t);
    List<T> retrieve() throws Exception;
    T search(int id) throws Exception;
    boolean delete(int id) throws Exception;
}


