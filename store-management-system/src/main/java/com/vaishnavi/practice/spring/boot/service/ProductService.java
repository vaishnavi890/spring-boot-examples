package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.Product;
import com.vaishnavi.practice.spring.boot.model.ProductUpdate;
import com.vaishnavi.practice.spring.boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.createProduct(product);
    }

    public Product deleteProduct(int id) {
        return repository.deleteProduct(id);
    }

    public Product retrieveProduct(int id) {
        return repository.retrieveProduct(id);
    }

    public List<Product> retrieveProduct(String name) {
        return repository.retrieveProduct(name);
    }

    public Map<Integer, Product> retrieveProducts() {
        return repository.retrieveProducts();
    }

    public Product updatePartialProduct(int id, ProductUpdate update) {
        return repository.updatePartialProduct(id, update);
    }

    public Product updateFullProduct(int id, ProductUpdate update) {
        return repository.updateFullProduct(id, update);
    }
}



