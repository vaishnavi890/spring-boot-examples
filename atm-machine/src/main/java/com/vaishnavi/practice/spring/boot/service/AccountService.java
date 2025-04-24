package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.Account;
import com.vaishnavi.practice.spring.boot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account deposit(Long accountNumber, double amount) throws Exception {
        Account account = getAccount(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long accountNumber, double amount) throws Exception {
        Account account = getAccount(accountNumber);
        if (account.getBalance() < amount) {
            throw new Exception("Insufficient balance!");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public double checkBalance(Long accountNumber) throws Exception {
        return getAccount(accountNumber).getBalance();
    }

    public Account getAccount(Long accountNumber) throws Exception {
        return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new Exception("Account not found"));
    }
}


