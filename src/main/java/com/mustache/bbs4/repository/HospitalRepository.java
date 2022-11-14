package com.mustache.bbs4.repository;

import com.mustache.bbs4.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByFullAddressContainingAndBusinessTypeNameIn(String name,List<String> businessName);
}
