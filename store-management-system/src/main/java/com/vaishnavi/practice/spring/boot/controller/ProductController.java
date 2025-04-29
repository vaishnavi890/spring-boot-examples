package com.vaishnavi.practice.spring.boot.controller;

import com.vaishnavi.practice.spring.boot.model.Product;
import com.vaishnavi.practice.spring.boot.model.ProductUpdate;
import com.vaishnavi.practice.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/storeManagement")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @GetMapping("/product/{id}")
    public Product retrieveProduct(@PathVariable int id) {
        return service.retrieveProduct(id);
    }

    @GetMapping("/product")
    public List<Product> retrieveByName(@RequestParam String name) {
        return service.retrieveProduct(name);
    }

    @GetMapping("/products")
    public List<Product> retrieveAll() {
        return service.retrieveProducts().values().stream().toList();
    }

    @PatchMapping("/product/{id}")
    public Product updatePartial(@PathVariable int id, @RequestBody ProductUpdate update) {
        return service.updatePartialProduct(id, update);
    }

    @PutMapping("/product/{id}")
    public Product updateFull(@PathVariable int id, @RequestBody ProductUpdate update) {
        return service.updateFullProduct(id, update);
    }
}



