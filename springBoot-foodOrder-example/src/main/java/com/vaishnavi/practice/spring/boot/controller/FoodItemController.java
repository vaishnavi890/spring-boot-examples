package com.vaishnavi.practice.spring.boot.controller;

import com.vaishnavi.practice.spring.boot.model.FoodItem;
import com.vaishnavi.practice.spring.boot.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodItemController {

    @Autowired
    private FoodItemService service;

    @GetMapping
    public List<FoodItem> getAllFoodItems() {
        return service.getAllFoodItems();
    }

    @PostMapping
    public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
        return service.addFoodItem(foodItem);
    }

    @PutMapping("/{id}")
    public FoodItem updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItem) {
        return service.updateFoodItem(id, foodItem);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodItem(@PathVariable Long id) {
        service.deleteFoodItem(id);
        return "Food item deleted successfully!";
    }
}

