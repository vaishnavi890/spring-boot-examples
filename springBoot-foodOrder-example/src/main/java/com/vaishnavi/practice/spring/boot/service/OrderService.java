package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.Order;
import com.vaishnavi.practice.spring.boot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order placeOrder(Order order) {
        order.setStatus("PENDING");
        return repository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setCustomerName(updatedOrder.getCustomerName());
        order.setCustomerPhone(updatedOrder.getCustomerPhone());
        order.setStatus(updatedOrder.getStatus());
        order.setTotalAmount(updatedOrder.getTotalAmount());
        return repository.save(order);
    }

    public void cancelOrder(Long id) {
        repository.deleteById(id);
    }
}


