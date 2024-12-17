package com.example.SpringHomework08.transfer.services.impl;

import com.example.SpringHomework08.transfer.aspect.TrackAction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.SpringHomework08.transfer.model.Account;
import com.example.SpringHomework08.transfer.repositories.AccountRepository;
import com.example.SpringHomework08.transfer.services.AccountService;

import java.util.List;

@Service
@AllArgsConstructor
public class iAccountService implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    @Override
    public Account getAccountById(Long id) {
        return accountRepository
                .findById(id).orElseThrow(null);
    }


    @Override
    public Account updateAccount(Long id, Account account) {
        Account accountByID = getAccountById(id);
        accountByID.setName(account.getName());
        accountByID.setAmount(account.getAmount());
        return accountRepository.save(accountByID);
    }


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }


    @Override
    public void deleteAccount(Long id) {
        Account accountByID = getAccountById(id);
        accountRepository.delete(accountByID);
    }
}
