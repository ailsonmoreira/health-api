package com.healthcare.api.auth;

public record LoginRequestDTO(
        String email,
        String password
) {
}
