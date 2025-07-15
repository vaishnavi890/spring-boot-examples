package com.vaishnavi.practice.spring.boot.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @RequestMapping({ "/balance" })
    public String checkBalance() {
        return "your balance is XXX";
    }

}
