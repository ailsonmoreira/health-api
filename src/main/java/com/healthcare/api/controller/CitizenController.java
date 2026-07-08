package com.healthcare.api.controller;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.service.CitizenService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT')")
    public ResponseEntity<Page<CitizenResponseDTO>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }
}

