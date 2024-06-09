package com.learning.hms.appointment_service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record DoctorDTO(
        Integer id, String firstName, String lastName, String specialty, String contactNumber, String email,
        Date createdAt
) {

}