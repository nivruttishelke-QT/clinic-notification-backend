package com.clinicalx.notification.entity;

import com.clinicalx.notification.enums.NotificationType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "event_mappings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clientId;

    private Long clinicId;

    private Long eventId;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;
}