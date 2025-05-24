package com.vaishnavi.practice.hibernate.repository;

import com.vaishnavi.practice.hibernate.model.Drawing;

import java.util.List;
import java.util.Optional;

public interface DrawingRepository {
    Drawing save(Drawing drawing);
    List<Drawing> findAll();
    Optional<Drawing> findById(int id);
    Drawing deleteById(int id);
}


