package com.healthcare.api.auth;

import com.healthcare.api.dto.LoginRequestDTO;
import com.healthcare.api.dto.LoginResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController (AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (
            @RequestBody LoginRequestDTO dto
            ) {
        return ResponseEntity.ok(service.login(dto));
    }
}
