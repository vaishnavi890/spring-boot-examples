package com.vaishnavi.practice.spring.boot.repository;

import com.vaishnavi.practice.spring.boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

