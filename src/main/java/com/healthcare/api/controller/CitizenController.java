package com.healthcare.api.controller;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.service.CitizenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService service;

    public CitizenController(CitizenService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CitizenResponseDTO> create(
            @Valid @RequestBody CitizenCreateDTO dto) {

        CitizenResponseDTO response = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

