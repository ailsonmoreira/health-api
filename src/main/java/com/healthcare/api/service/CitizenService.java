package com.healthcare.api.service;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.entity.Citizen;
import com.healthcare.api.repository.CitizenRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    private final CitizenRepository repository;

    public CitizenService(CitizenRepository repository) {
        this.repository = repository;
    }

    public CitizenResponseDTO create (CitizenCreateDTO dto){
        if (repository.existsByCpf((dto.cpf()))) {
            throw new RuntimeException("CPF already exists");
        }

        Citizen citizen = toEntity(dto);

        Citizen saved = repository.save(citizen);

        return new CitizenResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getCpf(),
                saved.getCns(),
                saved.getGender(),
                saved.getEducationLevel(),
                saved.getRace(),
                saved.getBirthDate(),
                saved.getPhone(),
                saved.getDiabetes(),
                saved.getSmoker(),
                saved.getAlcoholUse(),
                saved.getHeartDisease(),
                saved.getPregnant(),
                saved.getRespiratoryDisease()
        );
    }

    private static @NonNull Citizen toEntity(CitizenCreateDTO dto) {
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
        return citizen;
    }
}
