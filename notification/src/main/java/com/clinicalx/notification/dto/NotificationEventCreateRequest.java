package com.clinicalx.notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NotificationEventCreateRequest(

        @NotBlank
        String eventName,

        @NotBlank
        String description

) {
}