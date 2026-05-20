package com.healthcare.api.service;

import com.healthcare.api.dto.PersonCreateDTO;
import com.healthcare.api.dto.PersonResponseDTO;
import com.healthcare.api.entity.Person;
import com.healthcare.api.repository.PersonRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonResponseDTO create (PersonCreateDTO dto){
        if (repository.existsByCpf((dto.cpf()))) {
            throw new RuntimeException("CPF already exists");
        }

        Person person = toEntity(dto);

        Person saved = repository.save(person);

        return new PersonResponseDTO(
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

    private static @NonNull Person toEntity(PersonCreateDTO dto) {
        Person person = new Person();

        person.setName(dto.name());
        person.setCpf(dto.cpf());
        person.setCns(dto.cns());
        person.setGender(dto.gender());
        person.setEducationLevel(dto.educationLevel());
        person.setRace(dto.race());
        person.setBirthDate(dto.birthDate());
        person.setPhone(dto.phone());
        person.setDiabetes(dto.diabetes());
        person.setSmoker(dto.smoker());
        person.setAlcoholUse(dto.alcoholUse());
        person.setHeartDisease(dto.heartDisease());
        person.setPregnant(dto.pregnant());
        person.setRespiratoryDisease(dto.respiratoryDisease());
        return person;
    }
}
