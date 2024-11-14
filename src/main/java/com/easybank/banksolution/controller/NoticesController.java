package com.easybank.banksolution.controller;

import com.easybank.banksolution.model.Notice;
import com.easybank.banksolution.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {

    @Autowired
    NoticeRepository noticeRepository;

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getNotices() {
        List<Notice> allActiveNotices = noticeRepository.findAllActiveNotices();

        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(allActiveNotices);
    }

    @PostMapping("/addNotice")
    public ResponseEntity<String> addNotice(@RequestBody Notice notice) {
        Notice save = noticeRepository.save(notice);
        return ResponseEntity.status(HttpStatus.OK).body("Notice Published Successfully");
    }

}
