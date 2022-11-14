package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.domain.dto.HospitalResponse;
import com.mustache.bbs4.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HospitalRestController {

    private final HospitalRepository  hospitalRepository;

    public HospitalRestController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Long id) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);

        return ResponseEntity.ok(hospital.get().toString());
    }*/
}
