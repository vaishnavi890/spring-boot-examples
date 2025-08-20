package com.vaishnavi.practice.spring.boot.repository;

import com.vaishnavi.practice.spring.boot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}


