package com.vaishnavi.practice.spring.boot.repository;

import com.vaishnavi.practice.spring.boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

