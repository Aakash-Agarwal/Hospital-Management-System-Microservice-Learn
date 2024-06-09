package com.learning.hms.patient_service.service;

import com.learning.hms.patient_service.entities.Patient;
import com.learning.hms.patient_service.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return parsePatientCollentionToList(patientRepository.findAll());
    }

    public List<Patient> getPatientsByIdList(List<Integer> idList) {
        return parsePatientCollentionToList(patientRepository.findAllById(idList));
    }

    private List<Patient> parsePatientCollentionToList(Iterable<Patient> patients) {
        List<Patient> patientList = new ArrayList<>();
        patients.forEach(patient -> patientList.add(patient));

        return patientList;
    }
}
