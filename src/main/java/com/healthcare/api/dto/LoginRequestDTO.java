package com.healthcare.api.dto;

public record LoginRequestDTO(
        String email,
        String password
) {
}
