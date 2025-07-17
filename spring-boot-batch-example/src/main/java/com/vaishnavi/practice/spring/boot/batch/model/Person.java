package com.vaishnavi.practice.spring.boot.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    String firstName;
    String lastName;
    int age;
    boolean active;
}

