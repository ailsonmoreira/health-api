package com.healthcare.api.dto;

import com.healthcare.api.enums.EducationLevel;
import com.healthcare.api.enums.Gender;
import com.healthcare.api.enums.Race;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record PersonCreateDTO(

        @NotBlank
        String name,
        @CPF
        String cpf,
        @NotBlank
        String cns,
        @NotNull
        LocalDate birthDate,
        @NotNull
        Gender gender,
        @NotNull
        EducationLevel educationLevel,
        @NotNull
        Race race,

        String phone,

        Boolean diabetes,
        Boolean smoker,
        Boolean alcoholUse,
        Boolean heartDisease,
        Boolean pregnant,
        Boolean respiratoryDisease

) {}
