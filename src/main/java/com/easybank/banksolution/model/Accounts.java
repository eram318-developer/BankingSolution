package com.easybank.banksolution.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter @Setter
public class Accounts {

    @Column(name = "customer_id")
    private long customerId;

    @Id
    @Column(name="account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountNumber;

    @Column(name="account_type")
    private String accountType;

    @Column(name = "branch_address")
    private String branchAddress;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDt;

}