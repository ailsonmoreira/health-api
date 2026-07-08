package com.healthcare.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateDTO (

        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotNull
        Integer microArea
) {

}
