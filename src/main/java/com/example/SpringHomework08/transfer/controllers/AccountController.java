package com.example.SpringHomework08.transfer.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.SpringHomework08.transfer.model.Account;
import com.example.SpringHomework08.transfer.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") Long id) {
        Account accountById;
        try {
            accountById = accountService.getAccountById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Account());
        }
        return new ResponseEntity<>(accountById, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        return new ResponseEntity<>(accountService.updateAccount(id, account), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }

}
