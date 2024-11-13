package com.easybank.banksolution.repository;

import com.easybank.banksolution.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice,Long> {


    @Query("select notice FROM Notice notice where CURRENT_DATE between notice.noticeStDate and notice.noticeEdDate")
    List<Notice> findAllActiveNotices();
}
