package com.vaishnavi.spring.boot.hibernate.repository;

import com.vaishnavi.spring.boot.hibernate.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StudentRepository {
    Student save(Student student);
    List<Student> findAll();
    Optional<Student> findById(int id);
    Student deleteById(int id);
    List<Student> findStudentWithPagination(int page, int size);
}

