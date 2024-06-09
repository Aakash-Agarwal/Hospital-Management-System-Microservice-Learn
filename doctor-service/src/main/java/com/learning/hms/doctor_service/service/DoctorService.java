package com.learning.hms.doctor_service.service;

import com.learning.hms.doctor_service.repository.DoctorRepository;
import com.learning.hms.doctor_service.entities.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return parseDoctorCollentionToList(doctorRepository.findAll());
    }

    public List<Doctor> getDoctorsByIdList(List<Integer> idList) {
        return parseDoctorCollentionToList(doctorRepository.findAllById(idList));
    }

    private List<Doctor> parseDoctorCollentionToList(Iterable<Doctor> doctors) {
        List<Doctor> doctorList = new ArrayList<>();
        doctors.forEach(patient -> doctorList.add(patient));

        return doctorList;
    }
}
