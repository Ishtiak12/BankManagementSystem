package com.example.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}

