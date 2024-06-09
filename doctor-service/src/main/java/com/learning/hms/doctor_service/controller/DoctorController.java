package com.learning.hms.doctor_service.controller;

import com.learning.hms.doctor_service.entities.Doctor;
import com.learning.hms.doctor_service.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("{commaSeparatedIds}")
    public ResponseEntity<List<Doctor>> getDoctorsById(@PathVariable String commaSeparatedIds) {
        List<Integer> ids = convertStringListToIntegerList(
                StringUtils.hasText(commaSeparatedIds) ? Arrays.asList(commaSeparatedIds.split(",")) : Collections.emptyList()
        );

        List<Doctor> doctors = doctorService.getDoctorsByIdList(ids);

        return ResponseEntity.ok(doctors);
    }

    private List<Integer> convertStringListToIntegerList(List<String> strValues) {
        List<Integer> intValues = new ArrayList<>();
        strValues.forEach(str -> {
            try {
                intValues.add(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                log.error("Could not convert string to int, {}", str);
            }
        });

        return intValues;
    }
}
