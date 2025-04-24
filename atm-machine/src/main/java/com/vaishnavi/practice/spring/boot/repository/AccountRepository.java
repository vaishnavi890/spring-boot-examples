package com.vaishnavi.practice.spring.boot.repository;



import com.vaishnavi.practice.spring.boot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}


