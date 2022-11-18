package com.mustache.bbs4.repository;

import com.mustache.bbs4.domain.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findByBusinessTypeName() {
        /*List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        for (int i = 0; i < hospitals.size(); i++) {
            System.out.println(hospitals.get(i).toString());
        }

        System.out.println(hospitals.size());*/
    }

    @Test
    void allHospitalJPATest() {
        List<String> businessContains = new ArrayList<>();
        businessContains.add("보건소");
        businessContains.add("보건지소");
        businessContains.add("보건진료소");

        String addressName = "수원시";

        LocalDateTime localDateTime = LocalDateTime.of(2000,1,1,0,0,0);

        /*List<Hospital> hospitals1 = hospitalRepository.findByFullAddressContainingAndBusinessTypeNameIn(addressName, businessContains);
        List<Hospital> hospitals2 = hospitalRepository.findByBusinessStatusCode(2);
        List<Hospital> hospitals3 = hospitalRepository.findByRoadNameAddressLike("%수원%");
        List<Hospital> hospitals4 = hospitalRepository.findByRoadNameAddressContaining("수원");
        List<Hospital> hospitals5 = hospitalRepository.findByRoadNameAddressContains("수원");
        List<Hospital> hospitals6 = hospitalRepository.findByRoadNameAddressIsContaining("수원");
        List<Hospital> hospitals7 = hospitalRepository.findByRoadNameAddressStartingWith("서울");
        List<Hospital> hospitals8 = hospitalRepository.findByRoadNameAddressStartsWith("서울");
        List<Hospital> hospitals9 = hospitalRepository.findByPhoneEndingWith("8808");
        List<Hospital> hospitals10 = hospitalRepository.findByPhoneEndsWith("8808");
        List<Hospital> hospitals11 = hospitalRepository.findByPhoneIsNull();
        List<Hospital> hospitals12 = hospitalRepository.findByPhoneIsNotNull();
        List<Hospital> hospitals13 = hospitalRepository.findByLicenseDateBefore(localDateTime);
        List<Hospital> hospitals14 = hospitalRepository.findByLicenseDateAfter(localDateTime);
        List<Hospital> hospitals15 = hospitalRepository.findByIdLessThan(10L);
        List<Hospital> hospitals16 = hospitalRepository.findByIdGreaterThan(100000L);
        List<Hospital> hospitals17 = hospitalRepository.findByIdBetween(10L, 20L);
        List<Hospital> hospitals18 = hospitalRepository.findByRoadNameAddressContainsOrderById("수원");
        List<Hospital> hospitals19 = hospitalRepository.findByRoadNameAddressContainsOrderByIdDesc("수원");
        Long count = hospitalRepository.countByBusinessStatus(1);*/

        /*for(int i=0; i<hospitals18.size(); i++) {
            System.out.println(hospitals18.get(i).toString());
        }*/

        /*System.out.println(hospitals1.size());
        System.out.println(hospitals2.size());
        System.out.println(hospitals3.size());
        System.out.println(hospitals4.size());
        System.out.println(hospitals5.size());
        System.out.println(hospitals6.size());
        System.out.println(hospitals7.size());
        System.out.println(hospitals8.size());
        System.out.println(hospitals9.size());
        System.out.println(hospitals10.size());
        System.out.println(hospitals11.size());
        System.out.println(hospitals12.size());
        System.out.println(hospitals13.size());
        System.out.println(hospitals14.size());
        System.out.println(hospitals15.size());
        System.out.println(hospitals16.size());
        System.out.println(hospitals17.size());
        System.out.println(hospitals18.size());
        System.out.println(hospitals19.size());
        System.out.println(count);*/
    }

    @Test
    void numberOfBedbetween() {
        /*List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10,19);
        for (int i = 0; i < hospitals.size(); i++) {
            System.out.println(hospitals.get(i).toString());
        }
        System.out.println(hospitals.size());*/
    }
}