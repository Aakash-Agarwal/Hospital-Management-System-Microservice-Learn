package com.learning.hms.appointment_service.external_service;

import com.google.gson.Gson;
import com.learning.hms.appointment_service.dto.DoctorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final RestTemplate restTemplate;
    private final Gson gson;

    public Map<Integer, DoctorDTO> getDoctorsByIdList(List<Integer> idList) {
        Map<Integer, DoctorDTO> doctors = new HashMap<>();
        String commaSeparatedValues = idList.stream().map(Object::toString).collect(Collectors.joining(","));

        List<Object> response = restTemplate
                .getForEntity("http://API-GATEWAY/doctors/" + commaSeparatedValues, List.class)
                .getBody();

        response.forEach(obj -> {
            DoctorDTO doctorDTO = gson.fromJson(gson.toJson(obj), DoctorDTO.class);
            doctors.put(doctorDTO.id(), doctorDTO);
        });

        return doctors;
    }
}
