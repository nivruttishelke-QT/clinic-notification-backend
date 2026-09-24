package com.clinicalx.notification.controller;

import com.clinicalx.notification.dto.NotificationPreferenceUpdateRequest;
import com.clinicalx.notification.service.NotificationPreferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/communication-preferences")
@RequiredArgsConstructor
public class NotificationPreferenceController {

    private final NotificationPreferenceService preferenceService;

    @PostMapping
    public ResponseEntity<Void> savePreferences(
            @Valid @RequestBody NotificationPreferenceUpdateRequest request) {

        preferenceService.savePreferences(request);

        return ResponseEntity.ok().build();
    }

}