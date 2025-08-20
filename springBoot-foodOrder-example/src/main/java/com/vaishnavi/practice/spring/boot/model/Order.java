package com.vaishnavi.practice.spring.boot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String customerPhone;

    private String status;  // e.g., "PENDING", "CONFIRMED", "DELIVERED"

    private double totalAmount;
}


