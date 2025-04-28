package com.vaishnavi.practice.spring.boot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SolarPanel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String panelName;
    private String location;
    private Double capacity; // kW
    private String status; // Active, Inactive
}


