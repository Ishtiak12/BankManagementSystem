package com.example.Banking.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/perform")
    public void performTransaction(@RequestParam int accountId, @RequestParam String type, @RequestParam BigDecimal amount) {
        transactionService.performTransaction(accountId, type, amount);
    }
}
