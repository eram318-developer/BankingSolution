package com.easybank.banksolution.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter @Setter
@Table(name = "contact_messages")
public class Contact {

    @Id
    @Column(name = "contact_id")
    private String contactId;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_email")
    private String contactEmail;

    private String subject;

    private String message;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date createDt;

}
