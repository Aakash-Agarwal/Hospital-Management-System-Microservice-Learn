package com.learning.hms.patient_service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AppointmentDTO(
        String id, Integer patientId, Integer doctorId, String appointmentDate, String appointmentTime, String status,
        Date createdAt
) {

}