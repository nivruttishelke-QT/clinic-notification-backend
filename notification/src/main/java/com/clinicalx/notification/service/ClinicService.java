package com.clinicalx.notification.service;

import com.clinicalx.notification.dto.ClinicResponse;
import com.clinicalx.notification.repository.ClinicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public List<ClinicResponse> getClinicsByClient(Long clientId) {

        return clinicRepository.findByClientIdAndActiveTrue(clientId)
                .stream().map(clinic -> new ClinicResponse(clinic.getId(), clinic.getName())).toList();
    }
}