package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.Contact;
import com.easybank.banksolution.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ContactController{

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/contact")
    public Contact getContact(@RequestBody Contact contact) {
        contact.setContactId(getServiceReqNumber());
        return contactRepository.save(contact);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}
