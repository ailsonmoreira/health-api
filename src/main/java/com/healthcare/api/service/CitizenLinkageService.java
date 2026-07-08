package com.healthcare.api.service;

import com.healthcare.api.entity.Citizen;
import com.healthcare.api.repository.CitizenRepository;
import com.healthcare.api.repository.ResidenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CitizenLinkageService {
    private final CitizenRepository citizenRepository;
    private final ResidenceRepository residenceRepository;

    public CitizenLinkageService(CitizenRepository citizenRepository,
                                 ResidenceRepository residenceRepository) {
        this.citizenRepository = citizenRepository;
        this.residenceRepository = residenceRepository;
    }

    public void resolve(Citizen citizen) {
        // 1. resolve responsável familiar
        Citizen familyResponsible = null;

        if (citizen.getCpfResponsibleFamily() != null) {

            familyResponsible = citizenRepository
                    .findByCpf(citizen.getCpfResponsibleFamily())
                    .orElse(null);

            if (familyResponsible != null) {
                citizen.setFamilyResponsible(familyResponsible);
            }
        }

        // 2. resolve residência HERDADA do responsável familiar
        if (citizen.getResidence() == null && familyResponsible != null) {

            citizen.setResidence(familyResponsible.getResidence());
        }

        // 3. fallback: tenta residência direta (caso seja responsável)
        if (citizen.getResidence() == null) {

            residenceRepository.findByCpfResponsible(citizen.getCpf())
                    .ifPresent(citizen::setResidence);
        }
    }
}
