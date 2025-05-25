package com.vaishnavi.practice.hibernate.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String msg) {
        super(msg);
    }
}

