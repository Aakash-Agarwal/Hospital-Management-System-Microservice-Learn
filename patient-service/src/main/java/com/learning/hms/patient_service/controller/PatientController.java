package com.learning.hms.patient_service.controller;

import com.learning.hms.patient_service.entities.Patient;
import com.learning.hms.patient_service.service.PatientService;
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
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("{commaSeparatedIds}")
    public ResponseEntity<List<Patient>> getPatientsById(@PathVariable String commaSeparatedIds) {
        List<Integer> ids = convertStringListToIntegerList(
                StringUtils.hasText(commaSeparatedIds) ? Arrays.asList(commaSeparatedIds.split(",")) : Collections.emptyList()
        );
        List<Patient> patients = patientService.getPatientsByIdList(ids);

        return ResponseEntity.ok(patients);
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
