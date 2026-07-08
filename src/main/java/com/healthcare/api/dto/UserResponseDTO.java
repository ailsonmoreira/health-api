package com.healthcare.api.dto;

import com.healthcare.api.enums.Role;

public record UserResponseDTO(

        Long id,
        String name,
        String email,
        Role role,
        Integer microArea,
        boolean active
) {
}
