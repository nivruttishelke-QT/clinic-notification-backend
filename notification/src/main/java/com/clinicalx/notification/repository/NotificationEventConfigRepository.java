package com.clinicalx.notification.repository;

import com.clinicalx.notification.entity.NotificationEventConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationEventConfigRepository
        extends JpaRepository<NotificationEventConfig, Long> {

    List<NotificationEventConfig> findByClinicIdOrderByCreatedAtAsc(Long clinicId);

    Optional<NotificationEventConfig> findByIdAndClinicId(
            Long id,
            Long clinicId
    );

    boolean existsByClinicIdAndEventName(Long clinicId, String eventName);
}