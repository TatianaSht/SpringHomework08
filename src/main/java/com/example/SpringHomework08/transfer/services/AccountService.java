package com.example.SpringHomework08.transfer.services;

import com.example.SpringHomework08.transfer.model.Account;
import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account updateAccount(Long id, Account account);
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
