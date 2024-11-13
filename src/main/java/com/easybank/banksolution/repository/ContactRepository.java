package com.easybank.banksolution.repository;

import com.easybank.banksolution.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {


}
