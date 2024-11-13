package com.easybank.banksolution.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "notice_details")
public class Notice {

    @Id
    @Column(name = "notice_id")
    private long id;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_start_date")
    private Date noticeStDate;

    @Column(name = "notice_end_date")
    private Date noticeEdDate;

    @CreationTimestamp
    @Column(name = "notice_create_date")
    private Date createDate;

    @Column(name = "notice_update_date")
    private Date updateDate;
}
