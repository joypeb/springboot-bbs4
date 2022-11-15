package com.mustache.bbs4.controller;

import com.mustache.bbs4.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRestControllerTest {

    @Autowired
    HospitalRestController hospitalRestController;

    @Test
    @DisplayName("service에서 데이터를 잘 가공해서 받아오는지 테스트")
    void hospitalServiceTest() {
        System.out.println(hospitalRestController.get(1L).toString());
    }
}