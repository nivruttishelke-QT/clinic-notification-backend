package com.clinicalx.notification.dto;

import java.time.LocalDateTime;

public record NotificationEventResponse(

        Long id,
        Long clinicId,
        String eventName,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}