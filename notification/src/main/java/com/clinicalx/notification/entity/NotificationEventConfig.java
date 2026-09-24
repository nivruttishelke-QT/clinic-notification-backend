package com.clinicalx.notification.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_event_configs", uniqueConstraints = {@UniqueConstraint(columnNames = {"clinic_id", "event_name"})})
@Getter
@Setter
public class NotificationEventConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clinic_id", nullable = false)
    private Long clinicId;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();

        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}