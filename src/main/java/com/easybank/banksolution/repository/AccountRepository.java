package com.easybank.banksolution.repository;

import com.easybank.banksolution.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts,Long> {
    Accounts findByCustomerId(long id);
}
