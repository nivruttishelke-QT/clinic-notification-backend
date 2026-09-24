package com.clinicalx.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationEventCreateRequest(

        @NotNull
        Long clinicId,

        @NotBlank
        String eventName,

        @NotBlank
        String description

) {
}