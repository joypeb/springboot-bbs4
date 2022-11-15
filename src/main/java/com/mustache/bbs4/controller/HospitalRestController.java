package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.repository.HospitalRepository;
import com.mustache.bbs4.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController{

    private final HospitalService hospitalService;

    @Autowired
    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Long id) {
        HospitalResponse hospitalResponse = hospitalService.getHospital(id);
        return ResponseEntity.ok().body(hospitalResponse);
    }
}
