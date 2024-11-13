package com.easybank.banksolution.repository;

import com.easybank.banksolution.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards,Long> {

    List<Cards> findByCustomerId(long id);
}
