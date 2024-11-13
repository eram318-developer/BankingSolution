package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.AccountTransactions;
import com.easybank.banksolution.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController{

    @Autowired
    AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalance(@RequestParam long id) {
        List<AccountTransactions> accountTransactionList = accountTransactionsRepository.findByCustomerIdOrderByTransactionDt(id)!=null?accountTransactionsRepository.findByCustomerIdOrderByTransactionDt(id):null;
        return accountTransactionList;
    }
}
