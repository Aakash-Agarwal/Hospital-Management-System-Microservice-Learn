package com.learning.hms.doctor_service.repository;

import com.learning.hms.doctor_service.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
