package com.healthcare.api.controller;

import com.healthcare.api.dto.UserCreateDTO;
import com.healthcare.api.dto.UserResponseDTO;
import com.healthcare.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserResponseDTO> create  (
            @Valid @RequestBody UserCreateDTO dto
            ) {
        UserResponseDTO response = service.create(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
