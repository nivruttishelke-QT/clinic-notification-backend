package com.clinicalx.notification.entity;
import com.clinicalx.notification.enums.NotificationEvent;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "communication_preferences", uniqueConstraints = {@UniqueConstraint
        (columnNames = {"clinic_id", "notification_event"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommunicationPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "clinic_id", nullable = false)
    private Clinic clinic;

    @Enumerated(EnumType.STRING)
    @Column(name = "notification_event", nullable = false)
    private NotificationEvent notificationEvent;

    @Column(name = "whatsapp_enabled", nullable = false)
    private Boolean whatsappEnabled = false;

    @Column(name = "sms_enabled", nullable = false)
    private Boolean smsEnabled = false;

    @Column(name = "email_enabled", nullable = false)
    private Boolean emailEnabled = false;
}