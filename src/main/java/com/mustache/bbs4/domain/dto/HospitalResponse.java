package com.mustache.bbs4.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalResponse {
    private Long id;
    private String roadNameAddress;
    private String hospitalName;
    private int patientRoomCount;
    private int totalNumberOfBeds;
}
