package com.clinicalx.notification.dto;
import com.clinicalx.notification.enums.NotificationEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
public class NotificationPreferenceItem {

    @NotNull
    private NotificationEvent notificationEvent;

    @NotNull
    private Boolean whatsappEnabled;

    @NotNull
    private Boolean smsEnabled;

    @NotNull
    private Boolean emailEnabled;
}