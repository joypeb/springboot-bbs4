package com.mustache.bbs4.service;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalService.class)
class HospitalServiceTest {
    private HospitalRepository hospitalRepository = mock(HospitalRepository.class);
    private HospitalService hospitalService;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    void 폐점() {
        Hospital hospital = Hospital.builder().id(12314L).businessStatusCode(3).build();

        when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hospital));

        HospitalResponse closedHospital = hospitalService.getHospital(12314L);

        assertEquals("폐업", closedHospital.getBusinessStatusName());
    }

}