package com.clinicalx.notification.service;

import com.clinicalx.notification.dto.*;
import com.clinicalx.notification.entity.*;
import com.clinicalx.notification.exception.ResourceNotFoundException;
import com.clinicalx.notification.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationPreferenceService {

    private final ClinicRepository clinicRepository;
    private final CommunicationPreferenceRepository preferenceRepository;

    public void savePreferences(NotificationPreferenceUpdateRequest request) {

        Clinic clinic = clinicRepository.findById(request.getClinicId())
                .orElseThrow(() -> new ResourceNotFoundException("Clinic not found"));

        for (NotificationPreferenceItem item : request.getPreferences()) {

            CommunicationPreference preference = preferenceRepository.findByClinicIdAndNotificationEvent(clinic.getId(),
                            item.getNotificationEvent()).orElseGet(CommunicationPreference::new);

            preference.setClinic(clinic);
            preference.setNotificationEvent(item.getNotificationEvent());
            preference.setWhatsappEnabled(item.getWhatsappEnabled());
            preference.setSmsEnabled(item.getSmsEnabled());
            preference.setEmailEnabled(item.getEmailEnabled());

            preferenceRepository.save(preference);
        }
    }
}