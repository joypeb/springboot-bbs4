package com.mustache.bbs4.service;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Long id) {
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(id);
        Hospital hospital = hospitalOptional.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital);

        switch (hospital.getBusinessStatusCode()) {
            case 13:
                hospitalResponse.setBusinessStatusName("영업중");
                break;
            case 3:
                hospitalResponse.setBusinessStatusName("폐업");
                break;
            default:
                hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }

        return hospitalResponse;
    }
}
