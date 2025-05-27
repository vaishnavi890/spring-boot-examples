package com.vaishnavi.practice.spring.boot.jpa.model;

import lombok.Data;

@Data
public class CustomerModel {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    public Object getFirstName() {
        return null;
    }

    public Object getLastName() {
        return null;
    }

    public Object getEmail() {
        return null;
    }

    public void setId(Object id) {
    }

    public void setFirstName(Object firstName) {
    }

    public void setLastName(Object lastName) {
    }

    public void setEmail(Object email) {
    }
}

