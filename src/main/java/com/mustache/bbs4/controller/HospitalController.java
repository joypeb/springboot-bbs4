package com.mustache.bbs4.controller;

import com.mustache.bbs4.domain.Hospital;
import com.mustache.bbs4.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    @Autowired
    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("{id}")
    public String selectOne(@PathVariable Long id, Model model) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);

        if (hospital.isEmpty()) {
            model.addAttribute("id", id);
            return "error";
        } else {
            model.addAttribute("hospital", hospital.get());
            return "hospitalShowOne";
        }
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 20, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Hospital> hospitalPage = hospitalRepository.findAll(pageable);

        model.addAttribute("hospitalList", hospitalPage);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", hospitalPage.hasNext());
        model.addAttribute("hasPrevious", hospitalPage.hasPrevious());
        return "hospitalList";
    }
}
