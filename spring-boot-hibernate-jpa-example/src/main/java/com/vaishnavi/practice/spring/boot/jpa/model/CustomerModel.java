package com.vaishnavi.practice.spring.boot.jpa.model;

import lombok.Data;

@Data
public class CustomerModel {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;
}

