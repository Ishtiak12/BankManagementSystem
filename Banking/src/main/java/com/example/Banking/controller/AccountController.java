package com.example.Banking.controller;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking.model.Account;
import com.example.Banking.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public Account createAccount(@RequestParam String name, @RequestParam BigDecimal initialBalance) {
        return accountService.createAccount(name, initialBalance);
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable int id) {
        return accountService.getAccount(id);
    }
}
