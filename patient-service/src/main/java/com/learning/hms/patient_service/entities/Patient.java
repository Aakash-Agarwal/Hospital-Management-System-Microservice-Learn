package com.learning.hms.patient_service.entities;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data @Entity(name = "patients")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String contactNumber;
    private String email;
    private String address;
    private Date createdAt;
}
