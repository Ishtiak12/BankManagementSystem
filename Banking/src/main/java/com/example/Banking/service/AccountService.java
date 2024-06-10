package com.example.Banking.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(String accountHolderName, BigDecimal initialBalance) {
        Account account = new Account();
        account.setAccountHolderName(accountHolderName);
        account.setBalance(initialBalance);
        return accountRepository.save(account);
    }

    public Optional<Account> getAccount(int accountId) {
        return accountRepository.findById(accountId);
    }

    public synchronized void updateAccountBalance(int accountId, BigDecimal amount, boolean isDeposit) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            BigDecimal newBalance = isDeposit ? account.getBalance().add(amount) : account.getBalance().subtract(amount);
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }
}
