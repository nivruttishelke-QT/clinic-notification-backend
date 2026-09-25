package com.clinicalx.notification.repository;

import com.clinicalx.notification.entity.EventMapping;
import com.clinicalx.notification.enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventMappingRepository
        extends JpaRepository<EventMapping, Long> {

    List<EventMapping> findByClientId(Long clientId);

    List<EventMapping> findByClinicId(Long clinicId);

    List<EventMapping> findByClinicIdAndClientId(
            Long clinicId,
            Long clientId);

    boolean existsByClientIdAndClinicIdAndEventIdAndNotificationType(
            Long clientId,
            Long clinicId,
            Long eventId,
            NotificationType notificationType);
}