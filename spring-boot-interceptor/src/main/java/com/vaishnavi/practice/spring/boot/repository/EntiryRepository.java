package com.vaishnavi.practice.spring.boot.repository;


import com.vaishnavi.practice.spring.boot.model.Training;

import java.util.List;

public interface EntiryRepository {

    public boolean store(Training t);

    public List<Training> retrieve();

    public Training search(int id);

    public boolean delete(int id);
}


