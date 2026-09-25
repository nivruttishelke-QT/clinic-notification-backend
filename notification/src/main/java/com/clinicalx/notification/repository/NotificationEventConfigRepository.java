package com.clinicalx.notification.repository;

import com.clinicalx.notification.entity.NotificationEventConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationEventConfigRepository
        extends JpaRepository<NotificationEventConfig, Long> {

    List<NotificationEventConfig> findByOrderByCreatedAtAsc();

    Optional<NotificationEventConfig> findById(
            Long clinicId
    );

    boolean existsByEventName( String eventName);
}