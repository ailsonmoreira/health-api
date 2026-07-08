package com.healthcare.api.mapper;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.entity.Citizen;
import org.springframework.stereotype.Component;

@Component
public class CitizenMapper {
    public Citizen toEntity(CitizenCreateDTO dto) {

        Citizen citizen = new Citizen();

        citizen.setName(dto.name());
        citizen.setCpf(dto.cpf());
        citizen.setCns(dto.cns());
        citizen.setGender(dto.gender());
        citizen.setEducationLevel(dto.educationLevel());
        citizen.setRace(dto.race());
        citizen.setBirthDate(dto.birthDate());
        citizen.setPhone(dto.phone());
        citizen.setDiabetes(dto.diabetes());
        citizen.setSmoker(dto.smoker());
        citizen.setAlcoholUse(dto.alcoholUse());
        citizen.setHeartDisease(dto.heartDisease());
        citizen.setPregnant(dto.pregnant());
        citizen.setRespiratoryDisease(dto.respiratoryDisease());

        citizen.setMicroArea(dto.microArea());
        citizen.setCpfResponsibleFamily(dto.cpfResponsibleFamily());

        return citizen;
    }

    public CitizenResponseDTO toDTO(Citizen citizen) {

        return new CitizenResponseDTO(
                citizen.getId(),
                citizen.getName(),
                citizen.getCpf(),
                citizen.getCns(),
                citizen.getGender(),
                citizen.getEducationLevel(),
                citizen.getRace(),
                citizen.getBirthDate(),
                citizen.getPhone(),
                citizen.getDiabetes(),
                citizen.getSmoker(),
                citizen.getAlcoholUse(),
                citizen.getHeartDisease(),
                citizen.getPregnant(),
                citizen.getRespiratoryDisease(),
                citizen.getMicroArea(),
                citizen.getResidence() != null ? citizen.getResidence().getId() : null,
                citizen.getCpfResponsibleFamily(),
                citizen.getFamilyResponsible() != null
                        ? citizen.getFamilyResponsible().getId()
                        : null
        );
    }
}
