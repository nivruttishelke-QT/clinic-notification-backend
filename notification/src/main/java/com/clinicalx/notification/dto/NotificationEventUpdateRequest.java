package com.clinicalx.notification.dto;


import jakarta.validation.constraints.NotBlank;

public record NotificationEventUpdateRequest(

        @NotBlank
        String eventName,

        @NotBlank
        String description

) {
}