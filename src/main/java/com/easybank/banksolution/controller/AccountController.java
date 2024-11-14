package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.Accounts;
import com.easybank.banksolution.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/myAccount")
    public Accounts getAccount(@RequestParam long id) {
        Accounts account = accountRepository.findByCustomerId(id)!=null ? accountRepository.findByCustomerId(id) : null;
        return account;
    }
}
