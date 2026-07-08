package com.healthcare.api.service;

import com.healthcare.api.dto.ResidenceCreateDTO;
import com.healthcare.api.dto.ResidenceResponseDTO;
import com.healthcare.api.entity.Residence;
import com.healthcare.api.entity.User;
import com.healthcare.api.enums.Role;
import com.healthcare.api.mapper.ResidenceMapper;
import com.healthcare.api.repository.ResidenceRepository;
import com.healthcare.api.security.AuthenticatedUserService;
import org.springframework.stereotype.Service;

@Service
public class ResidenceService {
    private final ResidenceRepository repository;
    private final ResidenceMapper mapper;
    private final AuthenticatedUserService authenticatedUserService;

    public ResidenceService(ResidenceRepository repository,
                            ResidenceMapper mapper, AuthenticatedUserService authenticatedUserService) {
        this.repository = repository;
        this.mapper = mapper;
        this.authenticatedUserService = authenticatedUserService;
    }

    public ResidenceResponseDTO create(ResidenceCreateDTO dto) {

        Residence residence = mapper.toEntity(dto);

        User loggedUser =
                authenticatedUserService.getCurrentUser();

        Residence saved = repository.save(residence);

        defineMicroArea(residence, dto, loggedUser);

        return mapper.toDTO(saved);
    }

    private void defineMicroArea (Residence residence, ResidenceCreateDTO dto, User loggedUser) {
        if (loggedUser.getRole() == Role.ADMIN) {
            residence.setMicroArea(dto.microArea());
            return;
        }

        residence.setMicroArea(
                loggedUser.getMicroArea()
        );
    }
}
