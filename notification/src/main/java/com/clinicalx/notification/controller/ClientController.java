package com.clinicalx.notification.controller;


import com.clinicalx.notification.dto.ClientResponse;
import com.clinicalx.notification.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getClients() {

        return ResponseEntity.ok(
                clientService.getClients()
        );
    }
}