package com.learning.hms.patient_service.repository;

import com.learning.hms.patient_service.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
