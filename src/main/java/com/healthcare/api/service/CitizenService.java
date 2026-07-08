package com.healthcare.api.service;

import com.healthcare.api.dto.CitizenCreateDTO;
import com.healthcare.api.dto.CitizenResponseDTO;
import com.healthcare.api.entity.Citizen;
import com.healthcare.api.entity.User;
import com.healthcare.api.enums.Role;
import com.healthcare.api.mapper.CitizenMapper;
import com.healthcare.api.repository.CitizenRepository;
import com.healthcare.api.repository.ResidenceRepository;
import com.healthcare.api.security.AuthenticatedUserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
@Transactional
public class CitizenService {

    private final CitizenRepository repository;
    private final CitizenMapper mapper;
    private final CitizenLinkageService linkageService;
    private final AuthenticatedUserService authenticatedUserService;
    private final ResidenceRepository residenceRepository;

    public CitizenService(CitizenRepository repository,
                          CitizenMapper mapper,
                          CitizenLinkageService linkageService,
                          AuthenticatedUserService authenticatedUserService,
                          ResidenceRepository residenceRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.linkageService = linkageService;
        this.authenticatedUserService = authenticatedUserService;
        this.residenceRepository = residenceRepository;
    }

    public CitizenResponseDTO create(CitizenCreateDTO dto) {

        if (repository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF already exists");
        }

        User loggedUser =
                authenticatedUserService.getCurrentUser();

        Citizen citizen = mapper.toEntity(dto);

        //Verify if loggedUser is ADMIN or AGENT and save MicroArea according to the loggedUser's MicroArea.
        //If an ADMIN is logged, it allows to define a MicroArea manually
        if (loggedUser.getRole() == Role.ADMIN) {
            citizen.setMicroArea(
                    dto.microArea()
            );
        }
        else {
            citizen.setMicroArea(loggedUser.getMicroArea());
        }

        Citizen saved = repository.save(citizen);

        //It allows both residence and citizen to be saved asynchronously
        //without one needing to exist before the other.
        linkageService.resolve(saved);

        Citizen updated = repository.save(saved);

        return mapper.toDTO(updated);
    }

    public Page<CitizenResponseDTO> findAll(Pageable pageable){

        User loggedUser =
                authenticatedUserService.getCurrentUser();

        Page<Citizen> citizens;

        if (loggedUser.getRole() == Role.ADMIN) {
            citizens = repository.findAll(pageable);
        } else {
            citizens = repository.findAllByMicroArea(loggedUser.getMicroArea(), pageable);
        }

        return citizens.map(mapper::toDTO);

    }
}
