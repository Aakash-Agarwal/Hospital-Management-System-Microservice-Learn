package com.learning.hms.appointment_service.external_service;

import com.google.gson.Gson;
import com.learning.hms.appointment_service.dto.PatientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final RestTemplate restTemplate;
    private final Gson gson;

    public Map<Integer, PatientDTO> getPatientsByIdList(List<Integer> idList) {
        Map<Integer, PatientDTO> patients = new HashMap<>();
        String commaSeparatedValues = idList.stream().map(Object::toString).collect(Collectors.joining(","));

        List<Object> response = restTemplate
                .getForEntity("http://API-GATEWAY/patients/" + commaSeparatedValues, List.class)
                .getBody();

        response.forEach(obj -> {
            PatientDTO patientDTO = gson.fromJson(gson.toJson(obj), PatientDTO.class);
            patients.put(patientDTO.id(), patientDTO);
        });

        return patients;
    }
}
