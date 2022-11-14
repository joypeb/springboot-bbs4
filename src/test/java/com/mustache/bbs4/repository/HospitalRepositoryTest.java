package com.mustache.bbs4.repository;

import com.mustache.bbs4.domain.Hospital;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findByBusinessTypeName() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);

        for (int i = 0; i < hospitals.size(); i++) {
            System.out.println(hospitals.get(i).toString());
        }

        System.out.println(hospitals.size());
    }

    @Test
    void findByBusinessTypeNameAndAddressNameLikie() {
        List<String> businessContains = new ArrayList<>();
        businessContains.add("보건소");
        businessContains.add("보건지소");
        businessContains.add("보건진료소");

        String addressName = "수원시";

        List<Hospital> hospitals = hospitalRepository.findByFullAddressContainingAndBusinessTypeNameIn(addressName, businessContains);

        for (int i = 0; i < hospitals.size(); i++) {
            System.out.println(hospitals.get(i).toString());
        }

        System.out.println(hospitals.size());
    }
}