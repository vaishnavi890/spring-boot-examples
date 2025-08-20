package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.FoodItem;
import com.vaishnavi.practice.spring.boot.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository repository;

    public List<FoodItem> getAllFoodItems() {
        return repository.findAll();
    }

    public FoodItem addFoodItem(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    public FoodItem updateFoodItem(Long id, FoodItem updatedFoodItem) {
        FoodItem foodItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food item not found"));
        foodItem.setName(updatedFoodItem.getName());
        foodItem.setPrice(updatedFoodItem.getPrice());
        foodItem.setCategory(updatedFoodItem.getCategory());
        return repository.save(foodItem);
    }

    public void deleteFoodItem(Long id) {
        repository.deleteById(id);
    }
}
