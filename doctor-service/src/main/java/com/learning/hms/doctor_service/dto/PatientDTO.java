package com.learning.hms.doctor_service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PatientDTO(
        String id, String firstName, String lastName, String dob, String gender, String contactNumber, String email,
        String address, Date createdAt
) {

}