package com.healthcare.api.dto;

import com.healthcare.api.enums.EducationLevel;
import com.healthcare.api.enums.Gender;
import com.healthcare.api.enums.Race;

import java.time.LocalDate;

public record CitizenResponseDTO(

        Long id,

        String name,

        String cpf,

        String cns,

        Gender gender,

        EducationLevel educationLevel,

        Race race,

        LocalDate birthDate,

        String phone,

        Boolean diabetes,

        Boolean smoker,

        Boolean alcoholUse,

        Boolean heartDisease,

        Boolean pregnant,

        Boolean respiratoryDisease,

        Integer microArea,

        Long residenceId,

        String cpfResponsibleFamily,

        Long familyResponsibleId
) {
}
