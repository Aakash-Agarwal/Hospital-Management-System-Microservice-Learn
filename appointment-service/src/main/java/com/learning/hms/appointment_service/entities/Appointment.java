package com.learning.hms.appointment_service.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data @Entity(name = "appointments")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private Integer patientId;
    private Integer doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status;
    private Date createdAt;
}
