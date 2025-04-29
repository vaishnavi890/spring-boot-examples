package com.vaishnavi.practice.spring.boot.repository;

import com.vaishnavi.practice.spring.boot.model.Product;
import com.vaishnavi.practice.spring.boot.model.ProductUpdate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {
    Map<Integer, Product> data = new HashMap<>();

    public Product createProduct(Product product) {
        data.put(product.getId(), product);
        return product;
    }

    public Product deleteProduct(int id) {
        return data.remove(id);
    }

    public Product retrieveProduct(int id) {
        return data.get(id);
    }

    public List<Product> retrieveProduct(String name) {
        return data.values()
                .stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .toList();
    }

    public Map<Integer, Product> retrieveProducts() {
        return data;
    }

    public Product updatePartialProduct(int id, ProductUpdate update) {
        Product product = data.get(id);
        if (update.name() != null && !update.name().isEmpty()) product.setName(update.name());
        if (update.price() > 0) product.setPrice(update.price());
        if (update.quantity() >= 0) product.setQuantity(update.quantity());
        return product;
    }

    public Product updateFullProduct(int id, ProductUpdate update) {
        Product product = data.get(id);
        product.setName(update.name());
        product.setPrice(update.price());
        product.setQuantity(update.quantity());
        return product;
    }
}



