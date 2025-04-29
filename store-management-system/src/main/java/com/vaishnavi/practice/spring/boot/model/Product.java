package com.vaishnavi.practice.spring.boot.model;

import lombok.Data;

@Data
public class Product {
    int id;
    String name;
    double price;
    int quantity;

    public Integer getId() {
        return 0;
    }

    public String getName() {
        return "";
    }

    public void setName(String name) {
    }

    public void setPrice(double price) {
    }

    public void setQuantity(int quantity) {
    }
}


