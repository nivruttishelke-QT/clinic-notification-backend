package com.clinicalx.notification.service;

import com.clinicalx.notification.dto.NotificationEventCreateRequest;
import com.clinicalx.notification.dto.NotificationEventResponse;
import com.clinicalx.notification.dto.NotificationEventUpdateRequest;
import com.clinicalx.notification.entity.NotificationEventConfig;
import com.clinicalx.notification.repository.NotificationEventConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationEventConfigService {

    private final NotificationEventConfigRepository repository;

    @Transactional(readOnly = true)
    public List<NotificationEventResponse> getEvents() {

        return repository.findByOrderByCreatedAtAsc().stream().map(this::toResponse).toList();
    }

    @Transactional
    public NotificationEventResponse createEvent(NotificationEventCreateRequest request) {

        if (repository.existsByEventName( request.eventName())) {
            throw new IllegalArgumentException("Event already exists ");
        }

        NotificationEventConfig event = new NotificationEventConfig();

        event.setEventName(request.eventName());
        event.setDescription(request.description());

        NotificationEventConfig saved = repository.save(event);
        return toResponse(saved);
    }

    @Transactional
    public NotificationEventResponse updateEvent(Long id, NotificationEventUpdateRequest request) {

        NotificationEventConfig event = repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                                        "Notification event not found"));

        event.setEventName(request.eventName());
        event.setDescription(request.description());

        NotificationEventConfig updated = repository.save(event);
        return toResponse(updated);
    }

    @Transactional
    public void deleteEvent(Long id) {

        NotificationEventConfig event = repository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                                        "Notification event not found"));
        repository.delete(event);
    }

    private NotificationEventResponse toResponse(NotificationEventConfig event) {

        return new NotificationEventResponse(
                event.getId(),
                event.getEventName(),
                event.getDescription(),
                event.getCreatedAt(),
                event.getUpdatedAt()
        );
    }
}