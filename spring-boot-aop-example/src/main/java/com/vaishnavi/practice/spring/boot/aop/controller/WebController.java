package com.vaishnavi.practice.spring.boot.aop.controller;

import com.vaishnavi.practice.spring.boot.aop.service.FibonacciService;
import com.vaishnavi.practice.spring.boot.aop.config.LogMethodName;
import com.vaishnavi.practice.spring.boot.aop.config.MonitorTime;
import com.vaishnavi.practice.spring.boot.aop.config.RetryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class WebController {

    @Autowired
    private FibonacciService fibonacciService;

    @Cacheable("Fibonacci")
    @LogMethodName
    @MonitorTime
    @GetMapping(path = "/api/fibonacci/{number}")
    public Long fibonacci(@PathVariable(value = "number") Long number) {
        return fibonacciService.nthFibonacciTerm(number);
    }

    @RetryOperation
    @LogMethodName
    @PostMapping(path = "/api/storeData")
    public void storeData(@RequestParam(value = "data") String data) {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        } else {
            System.out.println("Pretend everything went fine");
        }
    }
}

