package com.learning.hms.appointment_service.controller;

import com.learning.hms.appointment_service.dto.AppointmentDTO;
import com.learning.hms.appointment_service.entities.Appointment;
import com.learning.hms.appointment_service.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("{commaSeparatedIds}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsById(@PathVariable String commaSeparatedIds) {
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByIdList(
                StringUtils.hasText(commaSeparatedIds) ? Arrays.asList(commaSeparatedIds.split(",")) : Collections.emptyList()
        );

        return ResponseEntity.ok(appointments);
    }
}
