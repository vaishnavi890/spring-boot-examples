package com.vaishnavi.practice.spring.boot.controller;

import com.vaishnavi.practice.spring.boot.model.Account;
import com.vaishnavi.practice.spring.boot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/deposit")
    public Account deposit(@RequestParam Long accountNumber, @RequestParam double amount) throws Exception {
        return accountService.deposit(accountNumber, amount);
    }

    @PutMapping("/withdraw")
    public Account withdraw(@RequestParam Long accountNumber, @RequestParam double amount) throws Exception {
        return accountService.withdraw(accountNumber, amount);
    }

    @GetMapping("/balance")
    public double checkBalance(@RequestParam Long accountNumber) throws Exception {
        return accountService.checkBalance(accountNumber);
    }
}


