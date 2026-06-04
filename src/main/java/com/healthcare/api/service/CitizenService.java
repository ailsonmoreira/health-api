package com.healthcare.api.service;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.entity.Citizen;
import com.healthcare.api.mapper.CitizenMapper;
import com.healthcare.api.repository.CitizenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CitizenService {

    private final CitizenRepository repository;
    private final CitizenMapper mapper;
    private final CitizenLinkageService linkageService;

    public CitizenService(CitizenRepository repository,
                          CitizenMapper mapper,
                          CitizenLinkageService linkageService) {
        this.repository = repository;
        this.mapper = mapper;
        this.linkageService = linkageService;
    }

    public CitizenResponseDTO create(CitizenCreateDTO dto) {

        if (repository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF already exists");
        }

        // 1. cria entity
        Citizen citizen = mapper.toEntity(dto);

        // 2. salva primeiro (AGORA ENTITY É GERENCIADA)
        Citizen saved = repository.save(citizen);

        // 3. resolve vínculo
        linkageService.resolve(saved);

        // 4. força persistência do vínculo (ESSENCIAL)
        Citizen updated = repository.save(saved);

        return mapper.toDTO(updated);
    }
}
