package com.healthcare.api.service;

import com.healthcare.api.dto.ResidenceCreateDTO;
import com.healthcare.api.dto.ResidenceResponseDTO;
import com.healthcare.api.entity.Residence;
import com.healthcare.api.mapper.ResidenceMapper;
import com.healthcare.api.repository.ResidenceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResidenceService {
    private final ResidenceRepository repository;
    private final ResidenceMapper mapper;

    public ResidenceService(ResidenceRepository repository,
                            ResidenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResidenceResponseDTO create(ResidenceCreateDTO dto) {

        Residence residence = mapper.toEntity(dto);

        Residence saved = repository.save(residence);

        return mapper.toDTO(saved);
    }
}
