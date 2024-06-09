package com.learning.hms.appointment_service.repository;

import com.learning.hms.appointment_service.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, String> {
}
