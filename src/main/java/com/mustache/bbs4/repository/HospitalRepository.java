package com.mustache.bbs4.repository;

import com.mustache.bbs4.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Page<Hospital> findAllByRoadNameAddressContaining(String name, Pageable pageable);
    /*List<Hospital> findByBusinessStatusCode(int code);
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByFullAddressContainingAndBusinessTypeNameIn(String name,List<String> businessName);
    List<Hospital> findByTotalNumberOfBedsBetween(int low, int high);
    List<Hospital> findByRoadNameAddressLike(String name);
    List<Hospital> findByRoadNameAddressContaining(String name);
    List<Hospital> findByRoadNameAddressContains(String name);
    List<Hospital> findByRoadNameAddressIsContaining(String name);
    List<Hospital> findByRoadNameAddressStartingWith(String addr);
    List<Hospital> findByRoadNameAddressStartsWith(String addr);
    List<Hospital> findByPhoneEndingWith(String num);
    List<Hospital> findByPhoneEndsWith(String num);
    List<Hospital> findByPhoneIsNull();
    List<Hospital> findByPhoneIsNotNull();
    List<Hospital> findByLicenseDateBefore(LocalDateTime date);
    List<Hospital> findByLicenseDateAfter(LocalDateTime date);
    List<Hospital> findByIdLessThan(Long num);
    List<Hospital> findByIdGreaterThan(Long num);
    List<Hospital> findByIdBetween(Long start, Long end);
    List<Hospital> findByRoadNameAddressContainsOrderById(String addr);
    List<Hospital> findByRoadNameAddressContainsOrderByIdDesc(String addr);
    Long countByBusinessStatus(int num);*/
}
