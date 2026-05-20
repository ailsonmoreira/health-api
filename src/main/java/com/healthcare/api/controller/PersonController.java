package com.healthcare.api.controller;

import com.healthcare.api.dto.PersonCreateDTO;
import com.healthcare.api.dto.PersonResponseDTO;
import com.healthcare.api.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PersonResponseDTO> create(
            @Valid @RequestBody PersonCreateDTO dto) {

        PersonResponseDTO response = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

