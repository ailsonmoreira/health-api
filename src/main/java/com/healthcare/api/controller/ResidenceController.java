package com.healthcare.api.controller;

import com.healthcare.api.dto.ResidenceCreateDTO;
import com.healthcare.api.dto.ResidenceResponseDTO;
import com.healthcare.api.service.ResidenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residences")
public class ResidenceController {

    private final ResidenceService service;

    public ResidenceController(ResidenceService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ResidenceResponseDTO> create(
            @RequestBody ResidenceCreateDTO dto
    ) {
        ResidenceResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}