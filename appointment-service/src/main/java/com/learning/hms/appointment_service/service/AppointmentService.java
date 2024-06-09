package com.learning.hms.appointment_service.service;

import com.learning.hms.appointment_service.dto.AppointmentDTO;
import com.learning.hms.appointment_service.dto.DoctorDTO;
import com.learning.hms.appointment_service.dto.PatientDTO;
import com.learning.hms.appointment_service.entities.Appointment;
import com.learning.hms.appointment_service.external_service.DoctorService;
import com.learning.hms.appointment_service.external_service.PatientService;
import com.learning.hms.appointment_service.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentRepository appointmentRepository;

    public List<AppointmentDTO> getAllAppointments() {
        return parseAppointmentCollentionToDTOList(appointmentRepository.findAll());
    }

    public List<AppointmentDTO> getAppointmentsByIdList(List<String> idList) {
        return parseAppointmentCollentionToDTOList(appointmentRepository.findAllById(idList));
    }

    private List<AppointmentDTO> parseAppointmentCollentionToDTOList(Iterable<Appointment> appointments) {
        List<AppointmentDTO> appointmentList = new ArrayList<>();
        List<Integer> doctorIdList = new ArrayList<>();
        List<Integer> patientIdList = new ArrayList<>();

        appointments.forEach(appointment -> doctorIdList.add(appointment.getDoctorId()));
        appointments.forEach(appointment -> patientIdList.add(appointment.getPatientId()));

        Map<Integer, DoctorDTO> doctors = doctorService.getDoctorsByIdList(doctorIdList);
        Map<Integer, PatientDTO> patients = patientService.getPatientsByIdList(patientIdList);

        appointments.forEach(appointment -> appointmentList.add(new AppointmentDTO(
                appointment.getId(), patients.get(appointment.getPatientId()), doctors.get(appointment.getDoctorId()),
                appointment.getAppointmentDate(), appointment.getAppointmentTime(), appointment.getStatus(),
                appointment.getCreatedAt()
                )
            )
        );

        return appointmentList;
    }
}
