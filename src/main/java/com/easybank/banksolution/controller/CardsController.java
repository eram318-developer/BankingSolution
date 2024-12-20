package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.Cards;
import com.easybank.banksolution.repository.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    CardsRepository cardsRepository;


    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam long id) {
        return cardsRepository.findByCustomerId(id) != null ? cardsRepository.findByCustomerId(id) : null;
    }
}
