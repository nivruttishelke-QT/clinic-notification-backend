package com.clinicalx.notification.controller;

import com.clinicalx.notification.dto.ClinicResponse;
import com.clinicalx.notification.service.ClinicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
@RequiredArgsConstructor
public class ClinicController {

    private final ClinicService clinicService;

    @GetMapping
    public ResponseEntity<List<ClinicResponse>> getClinics(
            @RequestParam Long clientId) {

        return ResponseEntity.ok(
                clinicService.
                        getClinicsByClient(clientId)
        );
    }
}