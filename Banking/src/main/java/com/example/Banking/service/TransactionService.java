package com.example.Banking.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Banking.model.Transaction;
import com.example.Banking.repository.TransactionRepository;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    @Transactional
    public void performTransaction(int accountId, String transactionType, BigDecimal amount) {
        Transaction transaction = new Transaction();
        transaction.setAccountId(accountId);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amount);
        transactionRepository.save(transaction);

        boolean isDeposit = "DEPOSIT".equals(transactionType);
        accountService.updateAccountBalance(accountId, amount, isDeposit);
    }
}

