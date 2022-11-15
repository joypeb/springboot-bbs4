package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.service.HospitalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HospitalRestController.class)
class HospitalRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean//hospitalService를 위해 가짜 객체를 쓰겠다
    HospitalService hospitalService;

    @Test
    @DisplayName("1개의 json으로 잘 오는지")
    void jsonResponse() throws Exception {
        HospitalResponse hospitalResponse = HospitalResponse.builder().id(2321L).roadNameAddress("서울특별시 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)")
                        .hospitalName("노소아청소년과의원").patientRoomCount(0).totalNumberOfBeds(0).businessStatusName("영업중").build();
        given(hospitalService.getHospital(2321L)).willReturn(hospitalResponse);

        Long hospitalId = 2321L;
        String url = "/api/v1/hospitals/" + hospitalId;

        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hospitalName").exists())
                .andExpect(jsonPath("$.hospitalName").value("노소아청소년과의원"))
                .andDo(print());

        verify(hospitalService).getHospital(hospitalId);
    }
}