package com.learning.hms.doctor_service.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data @Entity(name = "doctors")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String contactNumber;
    private String email;
    private Date createdAt;
}
