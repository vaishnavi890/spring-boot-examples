package com.vaishnavi.practice.spring.boot.model;

import jakarta.persistence.Entity;
import lombok.Getter;

import jakarta.persistence.*;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String role;

    // Constructors
    public Employee() {}
    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    // Getters & Setters
      public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

