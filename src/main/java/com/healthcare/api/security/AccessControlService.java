package com.healthcare.api.security;

import com.healthcare.api.entity.Citizen;
import com.healthcare.api.entity.Residence;
import com.healthcare.api.entity.User;
import com.healthcare.api.enums.Role;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class AccessControlService {
    public void validateCitizenAccess (
            User user,
            Citizen citizen
    ) throws AccessDeniedException {
        if (user.getRole() == Role.ADMIN) {
            return;
        }

        if (!user.getMicroArea().equals(citizen.getMicroArea())){
            throw new AccessDeniedException("Access denied");
        }
    }

    public void validateResidenceAccess (
            User user,
            Residence residence
    ) throws AccessDeniedException {
        if (user.getRole() == Role.ADMIN) {
            return;
        }

        if (!user.getMicroArea().equals(residence.getMicroArea())) {
            throw new AccessDeniedException("Access denied");
        }
    }
}
