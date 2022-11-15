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
    private String businessStatusName;

    public HospitalResponse(Long id, String roadNameAddress, String hospitalName, int patientRoomCount, int totalNumberOfBeds) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}