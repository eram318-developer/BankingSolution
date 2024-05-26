package com.easybank.banksolution.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String getAccount(){
        return "Welcome Everyone";
    }
    @GetMapping("/myBalance")
    public String getBalance(){
        return "Welcome Everyone";
    }
    @GetMapping("/myLoans")
    public String getLoans(){
        return "Welcome Everyone";
    }
    @GetMapping("/myCards")
    public String getCards(){
        return "Welcome Everyone";
    }
    @GetMapping("/notices")
    public String getNotices(){
        return "Welcome Everyone";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "Welcome Everyone";
    }
}
