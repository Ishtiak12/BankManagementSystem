package com.example.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}

