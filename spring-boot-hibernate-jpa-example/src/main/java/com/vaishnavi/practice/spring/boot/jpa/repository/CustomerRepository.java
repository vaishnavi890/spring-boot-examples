package com.vaishnavi.practice.spring.boot.jpa.repository;

import com.vaishnavi.practice.spring.boot.jpa.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}


