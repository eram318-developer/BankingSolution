package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.Loans;
import com.easybank.banksolution.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoans(@RequestParam long id) {
        List<Loans> loanList = loanRepository.findByCustomerIdOrderByStartDtDesc(id) != null ? loanRepository.findByCustomerIdOrderByStartDtDesc(id) : null;
        return loanList;
    }
}
