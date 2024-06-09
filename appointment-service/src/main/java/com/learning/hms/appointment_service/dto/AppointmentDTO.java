package com.learning.hms.appointment_service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.print.Doc;
import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AppointmentDTO(
        String id, PatientDTO patient, DoctorDTO doctor, String appointmentDate, String appointmentTime,
        String status, Date createdAt
) {

}