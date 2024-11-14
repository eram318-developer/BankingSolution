package com.easybank.banksolution.repository;

import com.easybank.banksolution.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Long> {


    @Query("SELECT notice FROM Notice notice WHERE CURRENT_TIMESTAMP BETWEEN notice.noticeStDate AND notice.noticeEdDate")
    List<Notice> findAllActiveNotices();


}
